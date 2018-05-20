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
		int theNumberOfDays = 0;
		if (theResult > 1) {
			for (int i = start + 1; i < end; i++) {
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
		int daysBetweenMonths = 0;
		int daysBetweenDays = 0;
		int startYear = this.start[2];
		int endYear = this.end[2];
		int startMonth = this.start[1];
		int endMonth = this.end[1];
		int startDay = this.start[0];
		int endDay = this.end[0];
		// change the start and end of years and months if the years are provided in
		// reverse
		if (startYear > endYear) {
			// change years
			int interimYear = startYear;
			startYear = endYear;
			endYear = interimYear;
			// change months
			int interimMonth = startMonth;
			startMonth = endMonth;
			endMonth = interimMonth;
		}
		int daysBetweenYears = this.calculatorForYears(startYear, endYear);
		// the dates are in the same year (for months)
		if (startYear == endYear) {
			daysBetweenMonths = calculatorForMonths(startMonth, endMonth, startYear);
		} else {
			int daysBetweenMonthsFirstPart = this.calculatorForMonthsStart(startMonth, 12, startYear);
			int daysBetweenMonthsSecondPart = this.calculatorForMonthsEnd(0, endMonth, endYear);
			daysBetweenMonths = daysBetweenMonthsFirstPart + daysBetweenMonthsSecondPart;
		}
		// the dates are in the same year on month (for days)
		if (startMonth == endMonth && startYear == endYear) {
			daysBetweenDays = calculatorForDays(startDay, endDay, startMonth, startYear);
		} else {
			int daysBetweenDaysFirstPart = this.calculatorForDaysStart(startDay, startMonth, startYear);
			int daysBetweenDaysSecondPart = this.calculatorForDaysEnd(endDay);
			daysBetweenDays = daysBetweenDaysFirstPart + daysBetweenDaysSecondPart;
		}
		int theTotalDays = daysBetweenYears + daysBetweenMonths + daysBetweenDays;
		return theTotalDays;
	}
}
