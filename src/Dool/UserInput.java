package Dool;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
	/*
	 * User enters the dates to be considered
	 */
	public void enterTheDays()
	 {
		Scanner input = new Scanner(System.in);
				while (true){
			        System.out.println("Input the start date.");
			        try {
//			            String uInputStartDate = input.nextLine(); 
//			            String stringToSearch = uInputStartDate;
//					    Pattern p = Pattern.compile("([0-9]{2})\\/([0-9]{2})\\/([0-9]{4})");   // the pattern to search for
//					    Matcher m = p.matcher(stringToSearch);
					    
			        	String uInputStartDate = receiveInputDate();
					    // now try to find at least one match
					    if (uInputStartDate != null && this.checkRangeGeneral(uInputStartDate)) {
					    	System.out.printf("You have entered (%s) as your start date. Now, please enter the end date %n ", uInputStartDate);
						    System.out.println("Input the end date.");
						    String uInputEndDate = receiveInputDate();
						    if (uInputEndDate != null && this.checkRangeGeneral(uInputEndDate)) {
						    	System.out.println("You have entered correct days.");
						    }
					      }
					    else { 
					    	 continue;
					    }
			        }
			        catch (Throwable t) {
			            // TODO handle better
			            t.printStackTrace();
			            break;
			        }
			        
			}
	}
	public String receiveInputDate() {
		Scanner input = new Scanner(System.in);
		String uInput = input.nextLine(); 
        String stringToSearch = uInput;
	    Pattern p = Pattern.compile("([0-9]{2})\\/([0-9]{2})\\/([0-9]{4})");   // the pattern to search for
	    Matcher m = p.matcher(stringToSearch);
	    if(!m.find()) {
	    	System.out.printf("The format of the entered date (%s) is incorrect. Please enter a correct date %n ", uInput);
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
		if(this.betweenNums(int_dd, 1, 31) && this.betweenNums(int_mm, 1, 12) && this.betweenNums(int_yyyy, 1901, 2999)) {
			// check if the year is a leap year			
			if(this.checkRangeMonths(int_dd, int_mm, int_yyyy)) {
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
	 * Finding out if the integer is between the range.
	 */
	public boolean betweenNums(int i, int minValueInclusive, int maxValueInclusive) {
	    return (i >= minValueInclusive && i <= maxValueInclusive);
	}
	/*
	 * Finding out if the entered year is a leap year
	 */
	public boolean leapYear(int theYear) {
	    boolean leapYear = false;
        if(theYear % 4 == 0)
        {
            if( theYear % 100 == 0)
            {
                // year is divisible by 400, hence the year is a leap year
                if ( theYear % 400 == 0) {
                	leapYear = true;
                }  
                else {
                	leapYear = false;
                }
                    
            }
            else {
            	leapYear = true;
            }
                
        } else {
        	leapYear = false;
        }
          	
		return leapYear;
	}
	/*
	 * Check if the days entered for the required months are in correct range
	 */
	public boolean checkRangeMonths(int theDay, int theMonth, int theYear) {
		int thirtyOneDays[] = {1, 3, 5, 7, 8, 10, 12};
		int thirtyDays[] = {4, 6, 9, 11};
		int february = 2;
		
		System.out.println("The month is " + theMonth);

		// check if month is 31 days		
		for (int i : thirtyOneDays) {
			if (i == theMonth && this.betweenNums(theDay, 1, 31)) {
				System.out.println("Found it in 31s ");
				return true;
			} 
		}
		//check if month is 30 days
		for (int i : thirtyDays) {
			if (i == theMonth && this.betweenNums(theDay, 1, 30)) {
				System.out.println("Found it in 30s ");
				return true;
			} 
		}
		// check for February
		if (theMonth == 2) {
			// if the year is leap year
			if (this.leapYear(theYear) && this.betweenNums(theDay, 1, 29)) {
				System.out.println("Found it in 29s ");
				return true;
			} else if (!this.leapYear(theYear) && this.betweenNums(theDay, 1, 28)) {
				System.out.println("Found it in 28s ");
				return true;
			} else {
				return false;
			} 
		}
		return false;
	}

	
}
