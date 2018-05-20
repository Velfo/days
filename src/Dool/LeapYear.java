package Dool;

public class LeapYear {
	/*
	 * Finding out if the entered year is a leap year
	 */
	public boolean leapYear(int theYear) {
		boolean leapYear = false;
		if (theYear % 4 == 0) {
			if (theYear % 100 == 0) {
				// year is divisible by 400, hence the year is a leap year
				if (theYear % 400 == 0) {
					leapYear = true;
				} else {
					leapYear = false;
				}

			} else {
				leapYear = true;
			}

		} else {
			leapYear = false;
		}

		return leapYear;
	}
}
