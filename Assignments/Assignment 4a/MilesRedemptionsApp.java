/***********************************************************
*                                                          *
*  CSCI 470/680      Assignment 4            Summer 2018   *
*                                                          *
*  Programmer: Yiannis Poulos                              *
*              Shaniel Omar Rivas Verdejo                  *
*                                                          *
*  Section:    2                                           *
*                                                          *
*  Date Due:   07/17/2018                                  *
*                                                          *
*  Purpose:    This program shows a list of possible       *
*              travel destinations for a client who wishes *
*              to redeem their accumulated frequent flyer  *
*              miles                                       *
*                                                          *
***********************************************************/

import java.util.Scanner;
import java.io.*;

public class MilesRedemptionsApp
{
  public static void main(String [] args) throws IOException
  {
    int userMiles = 0,        //Holds client's accumulated miles
        departMonth = 0,      //Holds client's month of departure
        remainingMiles = 0;   //Holds client's remaining miles
    
    String filename,          //Holds name of the file
           choice = "y";      //Holds user's choice to continue
    
    Scanner keyScan = new Scanner(System.in);   //Gets keyboard input from the user
    
    System.out.print("Please enter the name of the file: ");   //prompt user for name of the file
    filename = keyScan.next();
    
    File file = new File(filename);
    
    Scanner fileScanner = new Scanner(file);     //Reads data from input file
    
    //print welcome message
    System.out.println("----------------------------------------------------------------");
    System.out.println("WELCOME TO THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
    System.out.println("----------------------------------------------------------------");
    System.out.println();
    
    MilesRedeemer miles = new MilesRedeemer();  //object for MilesRedeemer class
    
    //print list of all possible destinations
    System.out.println("List of destination cities your client can travel to: ");
    System.out.println();   
    
    miles.readDestinations(fileScanner);
    
    for (String city : miles.getCityNames())
    {
      System.out.println(city);
    }
    
    System.out.println();
    
    do
    {
      System.out.println("----------------------------------------------------------------");
      System.out.print("Please enter your client's accumulated Frequent Flier Miles: ");   //prompt user for accumulated miles
      userMiles = keyScan.nextInt();
    
      System.out.print("Please enter your client's month of departure (1-12): ");  //prompt user for month of departure
      departMonth = keyScan.nextInt();
      
      //print list of redeemable tickets
      System.out.println();
      System.out.println("Your client's Frequent Flier miles can be used to redeem  the following tickets: ");
      System.out.println();
      
      for (String tickets : miles.redeemMiles(userMiles, departMonth))
      {
        System.out.println("* A trip to " + tickets + " in Economy Class");
      }
      
      remainingMiles = miles.getRemainingMiles();
      
      System.out.println();
      System.out.println("Your client's remaining Frequent Flyer Miles: " + remainingMiles);  //print client's remaining miles

      System.out.println("----------------------------------------------------------------");
      System.out.print("Do you want to continue (y/n)?: ");  //ask user if they wish to continue
      choice = keyScan.next();
    }
    
    while(choice.equals("y") || choice.equals("Y") || choice.equals("yes") || choice.equals("Yes") );
    
    //print exit message
    System.out.println();
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("THANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
    System.out.println("-------------------------------------------------------------------------");
    
    keyScan.close();   //close Scanner
  } 
}