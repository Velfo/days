package Dool;

public class Bashla {

	public static void main(String[] args) {

		UserInput usin = new UserInput();

		int[] theStartDate = usin.getTheStartDay();
		int[] theEndDate = usin.getTheEndDay();
		
	
		if (theStartDate != null && theEndDate != null) {
			DaysCalculator dCalc = new DaysCalculator(theStartDate, theEndDate);
		}
			

	}

}
