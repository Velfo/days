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
	 * Calculates number of days from start of the month to the date and from the
	 * date to the end of the month
	 */
	public int calculatorForDays() {

		return 0;
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
	 * Calculates number of days between two given years
	 */
	public int calculatorForYears(int start, int end) {
		int theResult = end - start;
		System.out.println("the result is " + theResult);
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
		// start[2] and end[2] are the years in the start and end arrays
		int daysBetweenYears = this.calculatorForYears(this.start[2], this.end[2]);
		// start[1] and end[1] are the months in the start and end arrays
		int daysBetweenMonthsFirstPart = this.calculatorForMonths(this.start[1], 12, this.start[2]);
		int daysBetweenMonthsSecondPart = this.calculatorForMonths(0, this.end[1], this.end[2]);
		
		System.out.println(daysBetweenYears);
		return 0;
	}
}
