/************************************************************
 *                                                          *
 *  CSCI 470/680     In-Class Exercise 4       Summer 2018  *                        
 *                                                          *
 *  Programmer:  Yianni Poulos                              *  
 *               Shaniel Omar Rivas Verdejo                 *
 *                                                          * 
 *                                                          *   
 *                                                          *
 *  Date Due:    July 10, 2018                              *                          
 *                                                          *
 ************************************************************/ 
//import java.util.Arrays;

public class Sieve
{
  public static void main(String[] args)
  {    
    boolean primeNum[] = new boolean [1000];
       
    for(int i = 0; i < 1000; i++)
    {
      primeNum [i] = true;
    }
    
    for(int j = 2; j*j < 1000; j++)
    {
      // If prime[j] is not changed, then it is a prime
      if(primeNum[j] == true)
      {
        // Update all multiples of j
        for(int i = j*2; i < 1000; i += j)
          primeNum[i] = false;
      }
    }
 
     // Print all prime numbers
     for(int i = 2; i < 1000; i++)
     {
       if(primeNum[i] == true)
         System.out.print(i + " ");
     }
     
  }
}