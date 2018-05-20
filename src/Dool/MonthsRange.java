package Dool;

public class MonthsRange {
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
	/*
	 * Get the exact number of days in a given month
	 */
	public int getTheExactDaysInMonth(int theMonth, int theYear) {
		int thirtyOneDays[] = { 1, 3, 5, 7, 8, 10, 12 };
		int thirtyDays[] = { 4, 6, 9, 11 };
		int february = 2;

		// check if month is 31 days
		for (int i : thirtyOneDays) {
			if (i == theMonth) {
				return 31;
			}	
		}
		// check if month is 30 days
		for (int i : thirtyDays) {
			if (i == theMonth) {
				return 30;
			}
		}
		// check for February
		if (theMonth == february) {
			// if the year is leap year
			LeapYear leapYear = new LeapYear();
			boolean itIsLeapYear = leapYear.leapYear(theYear);

			if (itIsLeapYear) {
				return 29;
			} else if (!itIsLeapYear) {
				return 28;
			}
		}
		return 0;
	}
	/*
	 * Finding out if the integer is between the range.
	 */
	public boolean betweenNums(int i, int minValueInclusive, int maxValueInclusive) {
		return (i >= minValueInclusive && i <= maxValueInclusive);
	}
}
