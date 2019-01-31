/**********************************************************
 *                                                        *
 *  CSCI 470/680-E       Assignment 3a       Summer 2018  *
 *                                                        *
 *  Developer(s):  Yiannis Poulos                         *
 *                 Shaniel Omar Verdejo                   *
 *                                                        *
 *  Section:  2                                           *
 *                                                        *
 *  Due Date/Time:  7/3/18 at 11:59pm                     *
 *                                                        *
 *  Purpose:  This program takes two dollar and cent      *
 *            amounts and calculates the total amount.    *
 *                                                        *
 **********************************************************/
 
import java.util.Scanner;

public class USMoneyDemo
{
  public static void main(String [] args)
  {
    int inputDollars;      //dollar amount entered by user 
    int inputCents;        //cent amount entered by user
    
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("Enter the amount of dollars: ");      //prompt user for dollar amount
    inputDollars = keyScan.nextInt();
    
    System.out.print("Enter the amount of cents: ");        //prompt user for cent amount
    inputCents = keyScan.nextInt();
    
    USMoney x = new USMoney(inputDollars, inputCents);      //object to represent first money amount
    
    System.out.print("Enter another amount of dollars: ");  //prompt user to enter another dollar amount
    inputDollars = keyScan.nextInt();
    
    System.out.print("Enter another amount of cents: ");    //prompt user to enter another dollar amount
    inputCents = keyScan.nextInt();
   
    USMoney y = new USMoney(inputDollars, inputCents);      //object to represent second money amount
    
    keyScan.close();
    
    USMoney total = x.plus(y);        //object to represent total sum of money
    
    //print total amount of money
    System.out.println("\nYou have: " + total.getDollars() + " dollars and " + total.getCents() + " cents");      
  }
}