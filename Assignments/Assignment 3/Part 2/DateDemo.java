/**********************************************************
 *                                                        *
 *  CSCI 470/680-E       Assignment 3b       Summer 2018  *
 *                                                        *
 *  Developer(s):  Yiannis Poulos                         *
 *                 Shaniel Rivas Verdejo                  *
 *                                                        *
 *  Section:  2                                           *
 *                                                        *
 *  Due Date/Time:  7/3/18 at 11:59pm                     *
 *                                                        *
 *  Purpose:  Calculates the number of days passed since  *
 *            January 1 of a given year.                  *
 *                                                        *
 **********************************************************/

import java.util.Scanner;

public class DateDemo          //Driver program for the Date class
{
  public static void main(String [] args)
  { 
    int inputDays = 0,         //declare variables to represent day,
        inputMonth = 0,        //month,
        inputYear = 0;         //and year
        
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("Enter an integer representing the day of the month (1-31): ");      //prompt user to enter day of the month
    inputDays = keyScan.nextInt();
    
    //Check if day input is valid
    while (inputDays < 1 || inputDays > 31)
    {
      System.out.print("***Invalid day value. Please enter a valid day of the month (1-31): ");
      inputDays = keyScan.nextInt();
    }
    
    System.out.print("Enter an integer representing the month (1-12): ");    //prompt user to enter month
    inputMonth = keyScan.nextInt();
    
    //Check if month input is valid
    while (inputMonth < 1 || inputMonth > 12)
    {
      System.out.print("***Invalid month value. Please enter a valid month (1-12): ");
      inputMonth = keyScan.nextInt();
    }
    
    System.out.print("Enter an integer representing the year: ");     //prompt user to enter year
    inputYear = keyScan.nextInt();
    
    Date days = new Date(inputDays, inputMonth, inputYear);           //create object to access class methods
       
    //output days since January 1
    System.out.print("\nThere have been " + days.daysSinceJan1(inputDays, inputMonth, inputYear));
    System.out.println(" days since January 1.");                    
    
    keyScan.close();     //close Scanner
  }
}  
