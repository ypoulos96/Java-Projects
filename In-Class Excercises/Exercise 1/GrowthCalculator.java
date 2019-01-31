/************************************************************
 *                                                          *
 *  CSCI 470/680     In-Class Exercise 1a      Summer 2018  *                        
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

public class GrowthCalculator
{
  public static void main(String [] args)
  {
    final double GROWTH_RATE = 0.0109;
    
    double population = 0,
           estimate = 0;
    
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("Enter the world's current population: ");
    
    population = keyScan.nextDouble();
    
    DecimalFormat aFormat = new DecimalFormat("###,###,###,###");
    
    for (int i = 1; i <= 5; i++)
    {
    estimate += (population * GROWTH_RATE);
    population += estimate;
    
    System.out.printf("\nPopulation after year %d is about %15s", i, aFormat.format(population));
    }
    
    System.out.println();
    keyScan.close();
  }
}
    