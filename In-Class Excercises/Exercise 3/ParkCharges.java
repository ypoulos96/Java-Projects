/************************************************************
 *                                                          *
 *  CSCI 470/680    In-Class Exercise 3a    Summer 2018     *                        
 *                                                          *
 *  Programmer:     Yiannis Poulos                          *  
 *                  Shaniel O Rivas Verdejo                 *
 *                                                          * 
 *                                                          *   
 *                                                          *
 *  Date Due:    July 5, 2018                               *                          
 *                                                          *
 ************************************************************/ 
import java.io.*;
import java.util.Scanner;

public class ParkCharges
{
  public static void main(String [] args) throws IOException
  {
    double parkInput,
           sum = 0,
           hourly = 0,
           hour = 0;
    
   String askInput;
    
    Scanner keyScan = new Scanner(System.in);
    
    do
    {  
      System.out.print("\n\nHow many hours did you park yesterday?: ");
      parkInput = keyScan.nextDouble();
    
      System.out.printf("\n");
    
      if(parkInput <= 3)
      {
        System.out.printf("You only paid $2.00 for those %.0f hours of parking yesterday \n", parkInput);
      }
      else if (parkInput > 3)
      {
      
        hourly = parkInput - 3;
        int i;
      
        for (i = 1; i <= hourly; i++)
        {
          hour = i * 0.50;
        }
      
        sum = 2 + hour;
      
        if(sum >= 10)
        {
          sum = 10;
        }
      
        System.out.printf("You only paid $%.2f for those %.0f hours of parking yesterday \n\n", sum, parkInput);
      
      }
      else if (parkInput == 24)
      {
        System.out.printf("\n\n\nYou only paid $10.00 for those %.0f hours of parking yesterday \n\n", parkInput);
      }
      
      System.out.print("Would you like to do another input?(yes/no): ");
      askInput = keyScan.next();     
    }
    
    while(askInput.equals("yes") || askInput.equals("Yes"));
    
    System.out.printf("\n\n\n");
    
    keyScan.close();
  }
}