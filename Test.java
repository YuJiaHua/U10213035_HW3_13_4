import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

class Printcalendar {
  /** Main method */
	
  //Declaring member variables year 、 month for 0
  static int year = 0;
  static int month = 0;
  //New GregorianCalendar calendar2 give year month and day
  static Calendar calendar = new GregorianCalendar(year,month - 1,0);
   
  public void Printcalendar(){
	  // Prompt the user to enter year 
	    Scanner input = new Scanner(System.in);

	    // Prompt the user to enter year
	    System.out.print("Enter full year : ");
	    year = input.nextInt();
	    
	    // Prompt the user to enter month
	    System.out.print("Enter month in number between 1 and 12: ");
	    month = input.nextInt();

	    // Print calendar for the month of the year
	    printMonth();
  }
  
  static void printMonth() {
	    // Print the headings of the calendar
	    printMonthTitle();

	    // Print the body of the calendar
	    printMonthBody();
	  }
  //Print the month title
  static void printMonthTitle() {
	    System.out.println("         " + getMonthName()
	      + " " + year);
	    System.out.println("-----------------------------");
	    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	  }
  
  // Get the English name for the month 
  static String getMonthName() {
	    String monthName = null;
	    switch (month) {
	      case 1: monthName = "January"; break;
	      case 2: monthName = "February"; break;
	      case 3: monthName = "March"; break;
	      case 4: monthName = "April"; break;
	      case 5: monthName = "May"; break;
	      case 6: monthName = "June"; break;
	      case 7: monthName = "July"; break;
	      case 8: monthName = "August"; break;
	      case 9: monthName = "September"; break;
	      case 10: monthName = "October"; break;
	      case 11: monthName = "November"; break;
	      case 12: monthName = "December";
	    }

	    return monthName;
	  }

  // Print month body 
  static void printMonthBody() {
	  
	    // New GregorianCalendar calendar2 give month of first day 1
	    Calendar calendar2 = new GregorianCalendar(year,month - 1,1);
	    
	    // Get start day of the week for the first date in the month
	    int StartDay = calendar2.get(Calendar.DAY_OF_WEEK) - 1;
	    
	    int i = 0;
	    for (i = 0; i < StartDay; i++)
	      System.out.print("    ");
	    
	    for (i = 1; i <= getNumberOfDaysInMonth(); i++) {
	        if (i < 10)
	          System.out.print("   " + i);
	        else
	          System.out.print("  " + i);

	        if ((i + StartDay) % 7 == 0)
	          System.out.println();
	      }

	    System.out.println();
	  }

  // Get the number of days in a month 
  static int getNumberOfDaysInMonth() {
	    if (month == 1 || month == 3 || month == 5 || month == 7 ||
	      month == 8 || month == 10 || month == 12)
	      return 31;

	    if (month == 4 || month == 6 || month == 9 || month == 11)
	      return 30;

	    if (month == 2) return isLeapYear() ? 29 : 28;

	    return 0; // If month is incorrect
	  }
  
  // Determine if it is a leap year 
  static boolean isLeapYear() {
	    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	  }
}

public class Test {
  // Main method 
  public static void main(String[] args) {
	  	//new Printcalendar
	  	Printcalendar myPrintcalendar = new Printcalendar();
		  //call Printcalendar
	  	myPrintcalendar.Printcalendar();
  }
}
