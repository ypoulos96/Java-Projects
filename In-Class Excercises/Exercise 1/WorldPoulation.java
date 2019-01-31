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

public class WorldPoulation
{
  public static void main(String[] args)
  {
    double inputUser;
    
    double estimated = 0;
    
    final double GROWTH_RATE = 0.0109;
    
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("What's the world population now? ");
    
    inputUser = keyScan.nextInt();
    
    int i;
    
    DecimalFormat aFormat = new DecimalFormat("###,###,###,###");
    
    for(i = 1; i < 6; i++)
    { 
      
      estimated += (inputUser*GROWTH_RATE)+inputUser;
    
      System.out.printf("\nPredicted population for year %d is %15s", i, aFormat.format(estimated) );
    }
    
    keyScan.close();
    System.out.printf("\n\n\n\n");
  }
}