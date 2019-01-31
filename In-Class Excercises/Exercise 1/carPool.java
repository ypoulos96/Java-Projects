/************************************************************
 *                                                          *
 *  CSCI 470/680     In-Class Exercise 1b      Summer 2018  *                        
 *                                                          *
 *  Programmer:  Yiannis Poulos                             *  
 *               Shaniel O Rivas Verdejo                    *
 *                                                          * 
 *                                                          *   
 *                                                          *
 *  Date Due:    June 26, 2018                              *                          
 *                                                          *
 ************************************************************/ 
import java.text.DecimalFormat;
import java.util.Scanner;

public class carPool
{
  public static void main(String[] args)
  {
    double milesInput,
             gasInput,
             mpgInput,
            parkInput,
            tollInput,
             sumTotal;
    
    DecimalFormat aFormat = new DecimalFormat("$###,###,##0.00");
    
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("Total miles driven: ");
    milesInput = keyScan.nextDouble();
    
    System.out.print("Price per gallon: ");
    gasInput = keyScan.nextDouble();
    
    System.out.print("Miles per gallon: ");
    mpgInput = keyScan.nextInt();
    
    System.out.print("Parking fee today (if any): ");
    parkInput = keyScan.nextDouble();
    
    System.out.print("Tolls (if any): ");
    tollInput = keyScan.nextDouble();
    
    keyScan.close();
    
    System.out.printf("\n\n\n\nTotal Miles Driven:   %20.2f", milesInput);
    System.out.printf("\nThe price per gallon: %20s", aFormat.format(gasInput));
    System.out.printf("\nYour car MPG is:      %20.2f", mpgInput);
    System.out.printf("\nParking fees:         %20s", aFormat.format(parkInput));
    System.out.printf("\nTolls:                %20s", aFormat.format(tollInput));
    
    sumTotal = ((milesInput/mpgInput)*gasInput) + parkInput + tollInput;
    
    System.out.printf("\n\nTotal cost:           %20s\n\n", aFormat.format(sumTotal));
    
  }
}
    
    