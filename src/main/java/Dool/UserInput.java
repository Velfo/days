package Dool;

import java.util.Scanner;

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
				t.printStackTrace();
				break;
			}
		}
		return null;
	}

	/*
	 * Receive the input from user
	 */
	public String receiveInputDate() {
		Scanner input = new Scanner(System.in);
		String uInput = input.nextLine();
		String inputString = uInput.trim();
		if(inputString.length() == 10 && inputString.charAt(2) == '/' && inputString.charAt(5) == '/'){
            return uInput;
		}
        System.out.printf("The format of the entered date (%s) is incorrect.%n", uInput);
        return null;
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
		MonthsRange monthRange = new MonthsRange();
		// check the range of numbers is okay
		if (monthRange.betweenNums(int_parts[0], 1, 31) && monthRange.betweenNums(int_parts[1], 1, 12)
				&& monthRange.betweenNums(int_parts[2], 1901, 2999)) {
			// check if the year is a leap year
			if (monthRange.checkRangeMonths(int_parts[0], int_parts[1], int_parts[2])) {
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
}
