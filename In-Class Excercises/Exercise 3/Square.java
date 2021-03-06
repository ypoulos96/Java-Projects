/************************************************************
 *                                                          *
 *  CSCI 470/680    In-Class Exercise 3b    Summer 2018     *                        
 *                                                          *
 *  Programmer:     Yiannis Poulos                          *  
 *                  Shaniel O Rivas Verdejo                 *
 *                                                          * 
 *                                                          *   
 *                                                          *
 *  Date Due:    July 5, 2018                               *                          
 *                                                          *
 ************************************************************/ 

import java.util.Scanner;

public class Square
{  
  public static void squareOfAsterisks(int x)
  {
    for (int i = 0; i < x; i++)
    {
      for (int j = 0; j < x; j++)
      {
        System.out.print("*");
      }
      
      System.out.println();
    }
  }
  
  public static void main(String [] args)
  {
    int width = 0;
    String choice = "";
    
    Scanner keyScan = new Scanner(System.in);
    
    do
   {
    System.out.print("Enter the width of the square: ");
    width = keyScan.nextInt();
    
    squareOfAsterisks(width);
    
    System.out.print("\nWould you like to print another square?(yes/no): ");
    choice = keyScan.next();
    }
    
    while(choice.equals("Yes") || choice.equals("yes"));
    
    System.out.print("\n\n\n");
    
    keyScan.close();
  }
}
  
  
  