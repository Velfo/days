package Dool;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
	Scanner input = new Scanner(System.in);

	/*
	 * User enters the start date
	 */
	public int[] getTheStartDay() {
		while (true) {
			System.out.println("Please, input the start date in dd/mm/yyyy format: ");
			try {
				int[] userInputInArrayFormat = new int[3];
				// now try to find at least one match
				String uInputStartDate = receiveInputDate();
				if (uInputStartDate != null) {
					userInputInArrayFormat = this.parseInputDate(uInputStartDate);
				}
				if (uInputStartDate != null && userInputInArrayFormat != null) {
					System.out.printf("You have entered (%s) as your start date. %n", uInputStartDate);
					return userInputInArrayFormat;
				} else {
					continue;
				}
			} catch (Throwable t) {
				// TODO handle better
				t.printStackTrace();
				break;
			}
		}
		return null;
	}

	/*
	 * User enters the start date
	 */
	public int[] getTheEndDay() {
		while (true) {
			System.out.println("Please, input the end date in dd/mm/yyyy format: ");
			try {
				int[] userInputInArrayFormat = new int[3];
				// now try to find at least one match
				String uInputEndDate = receiveInputDate();
				if (uInputEndDate != null) {
					userInputInArrayFormat = this.parseInputDate(uInputEndDate);
				}
				if (uInputEndDate != null && userInputInArrayFormat != null) {
					System.out.printf("You have entered (%s) as your end date. %n", uInputEndDate);
					return userInputInArrayFormat;
				} else {
					continue;
				}
			} catch (Throwable t) {
				// TODO handle better
				t.printStackTrace();
				break;
			}
		}
		return null;
	}

	/*
	 * Receive the .
	 */
	public String receiveInputDate() {
		Scanner input = new Scanner(System.in);
		String uInput = input.nextLine();
		String stringToSearch = uInput;
		Pattern p = Pattern.compile("([0-9]{2})\\/([0-9]{2})\\/([0-9]{4})"); // the pattern to search for
		Matcher m = p.matcher(stringToSearch);
		if (!m.find()) {
			System.out.printf("The format of the entered date (%s) is incorrect.%n", uInput);
			return null;
		}
		return uInput;
	}

	/*
	 * Making sure that the general range in the input string is okay.
	 */
	public boolean checkRangeGeneral(String userInput) {
		// split the user input
		String[] parts = userInput.split("/");
		String dd = parts[0];
		String mm = parts[1];
		String yyyy = parts[2];
		// parse the user input
		int int_dd = Integer.parseInt(dd);
		int int_mm = Integer.parseInt(mm);
		int int_yyyy = Integer.parseInt(yyyy);
		// check the range of numbers is okay
		if (this.betweenNums(int_dd, 1, 31) && this.betweenNums(int_mm, 1, 12)
				&& this.betweenNums(int_yyyy, 1901, 2999)) {
			// check if the year is a leap year
			if (this.checkRangeMonths(int_dd, int_mm, int_yyyy)) {
				System.out.println("The range is okay");
				return true;
			} else {
				System.out.println("The range for MONTHS is not okay");
				return false;
			}
		} else {
			System.out.println("The range is not okay");
			return false;
		}
	}

	/*
	 * Making sure that the general range in the input string is okay.
	 */
	public int[] parseInputDate(String userInput) {
		// split the user input
		String[] parts = userInput.split("/");
		String dd = parts[0];
		String mm = parts[1];
		String yyyy = parts[2];
		// parse the user input
		int[] int_parts = new int[3];
		int_parts[0] = Integer.parseInt(dd);
		int_parts[1] = Integer.parseInt(mm);
		int_parts[2] = Integer.parseInt(yyyy);
		// check the range of numbers is okay
		if (this.betweenNums(int_parts[0], 1, 31) && this.betweenNums(int_parts[1], 1, 12)
				&& this.betweenNums(int_parts[2], 1901, 2999)) {
			// check if the year is a leap year
			if (this.checkRangeMonths(int_parts[0], int_parts[1], int_parts[2])) {
				System.out.println("The range is okay");
				return int_parts;
			} else {
				System.out.println("The range for MONTHS is not okay");
				return null;
			}
		} else {
			System.out.println("The range is not okay");
			return null;
		}
	}

	/*
	 * Finding out if the integer is between the range.
	 */
	public boolean betweenNums(int i, int minValueInclusive, int maxValueInclusive) {
		return (i >= minValueInclusive && i <= maxValueInclusive);
	}

	/*
	 * Check if the days entered for the required months are in correct range
	 */
	public boolean checkRangeMonths(int theDay, int theMonth, int theYear) {
		int thirtyOneDays[] = { 1, 3, 5, 7, 8, 10, 12 };
		int thirtyDays[] = { 4, 6, 9, 11 };
		int february = 2;

		// check if month is 31 days
		for (int i : thirtyOneDays) {
			if (i == theMonth && this.betweenNums(theDay, 1, 31)) {
				return true;
			}
		}
		// check if month is 30 days
		for (int i : thirtyDays) {
			if (i == theMonth && this.betweenNums(theDay, 1, 30)) {
				return true;
			}
		}
		// check for February
		if (theMonth == february) {
			// if the year is leap year
			LeapYear leapYear = new LeapYear();
			boolean itIsLeapYear = leapYear.leapYear(theYear);

			if (itIsLeapYear && this.betweenNums(theDay, 1, 29)) {
				return true;
			} else if (!itIsLeapYear && this.betweenNums(theDay, 1, 28)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
