package Dool;

public class DaysCalculator {
	int[] start;
	int[] end;
	LeapYear leapYear;
	MonthsRange monthRange;

	/*
	 * Constructor with two input arrays containing start and end dates
	 */
	public DaysCalculator(int[] start, int[] end) {
		this.start = start;
		this.end = end;
		this.leapYear = new LeapYear();
		this.monthRange = new MonthsRange();
	}

	/*
	 * Calculates number of day between dates if the dates are in the same month and
	 * year
	 */
	public int calculatorForDays(int startDay, int endDay, int theMonth, int theYear) {
		int theResult = endDay - startDay;
		System.out.println("the result is " + theResult);
		int theNumberOfDays = 0;
		if (theResult > 1) {
			for (int i = startDay + 1; i < endDay; i++) {
				theNumberOfDays++;
			}
		}
		return theNumberOfDays;
	}

	/*
	 * Calculates number of day between dates if the dates are in adjacent months
	 * (the start month)
	 */
	public int calculatorForDaysStart(int startDay, int theMonth, int theYear) {
		// check how many days in the month
		int totalDaysInTheMonths = this.monthRange.getTheExactDaysInMonth(theMonth, theYear);
		int theNumberOfDays = totalDaysInTheMonths - startDay;
		return theNumberOfDays;
	}

	/*
	 * Calculates number of day between dates if the dates are in adjacent months
	 * (the end month)
	 */
	public int calculatorForDaysEnd(int endDay) {
		int theNumberOfDays = endDay - 1;
		return theNumberOfDays;
	}

	/*
	 * Calculates number of days between two given months in a specific year
	 */
	public int calculatorForMonths(int startMonth, int endMonth, int theYear) {
		int theResult = endMonth - startMonth;
		System.out.println("the result is " + theResult);
		int theNumberOfDays = 0;
		if (theResult > 1) {
			for (int i = startMonth + 1; i < endMonth; i++) {
				theNumberOfDays += this.monthRange.getTheExactDaysInMonth(i, theYear);
			}
		}
		return theNumberOfDays;
	}

	/*
	 * Calculates number of days between two given months in a specific year (from
	 * the given month till the end of year)
	 */
	public int calculatorForMonthsStart(int startMonth, int endMonth, int theYear) {
		int theResult = endMonth - startMonth;
		System.out.println("the result is " + theResult);
		int theNumberOfDays = 0;
		if (theResult > 1) {
			for (int i = startMonth + 1; i <= endMonth; i++) {
				theNumberOfDays += this.monthRange.getTheExactDaysInMonth(i, theYear);
			}
		}
		return theNumberOfDays;
	}

	/*
	 * Calculates number of days between two given months in a specific year (from
	 * the beginning of the year to the given month)
	 */
	public int calculatorForMonthsEnd(int startMonth, int endMonth, int theYear) {
		int theResult = endMonth - startMonth;
		System.out.println("the result is " + theResult);
		int theNumberOfDays = 0;
		if (theResult > 1) {
			for (int i = startMonth; i < endMonth; i++) {
				theNumberOfDays += this.monthRange.getTheExactDaysInMonth(i, theYear);
			}
		}
		return theNumberOfDays;
	}

	/*
	 * Calculates number of days between two given years
	 */
	public int calculatorForYears(int start, int end) {
		int theResult = end - start;
		System.out.println("the result is " + theResult);
		int theNumberOfDays = 0;
		if (theResult > 1) {
			for (int i = start + 1; i < end; i++) {
				System.out.println("the year is " + i);
				if (this.leapYear.leapYear(i)) {
					theNumberOfDays += 366;
				} else {
					theNumberOfDays += 365;
				}
			}
		}
		return theNumberOfDays;
	}

	/*
	 * The start and end dates
	 */
	public void setTheStarAndEndDate(int[] start, int[] end) {
		this.start = start;
		this.end = end;
	}

	/*
	 * Calculates and returns the number of days between the dates
	 */
	public int calculateTheResult() {
		// start[2] and end[2] are the years in the start and end arrays
		int daysBetweenYears = this.calculatorForYears(this.start[2], this.end[2]);
		int daysBetweenMonths = 0;
		int daysBetweenDays = 0;
		int startYear = this.start[2];
		int endYear = this.end[2];
		if(startYear > endYear) {
			int interim = startYear;
			startYear = endYear;
			endYear = interim;
		}
		// the dates are in the same year
		if (this.start[2] == this.end[2]) {
			daysBetweenMonths = calculatorForMonths(this.start[1], this.end[1], this.start[2]);
		} else {
			// start[1] and end[1] are the months in the start and end arrays
			int daysBetweenMonthsFirstPart = this.calculatorForMonthsStart(this.start[1], 12, this.start[2]);
			int daysBetweenMonthsSecondPart = this.calculatorForMonthsEnd(0, this.end[1], this.end[2]);
			System.out.println("daysBetweenMonthsFirstPart "+ daysBetweenMonthsFirstPart);
			System.out.println("daysBetweenMonthsSecondPart "+ daysBetweenMonthsSecondPart);
			daysBetweenMonths = daysBetweenMonthsFirstPart + daysBetweenMonthsSecondPart;
		}
		// the dates are in the same year on month (for days)
		if (this.start[1] == this.end[1] && this.start[2] == this.end[2]) {
			daysBetweenDays = calculatorForDays(this.start[0], this.end[0], this.start[1], this.start[2]);
		} else {
			// start[1] and end[1] are the months in the start and end arrays
			int daysBetweenDaysFirstPart = this.calculatorForDaysStart(this.start[0], this.start[1], this.start[2]);
			int daysBetweenDaysSecondPart = this.calculatorForDaysEnd(this.end[0]);
			System.out.println("daysBetweenDaysFirstPart "+ daysBetweenDaysFirstPart);
			System.out.println("daysBetweenDaysSecondPart "+ daysBetweenDaysSecondPart);
			daysBetweenDays = daysBetweenDaysFirstPart + daysBetweenDaysSecondPart;
		}
		int theTotalDays = daysBetweenYears + daysBetweenMonths + daysBetweenDays; 
		System.out.println("daysBetweenYears "+daysBetweenYears);
		System.out.println("daysBetweenMonths "+daysBetweenMonths);
		System.out.println("daysBetweenDays "+ daysBetweenDays);
		return 0;
	}
}
