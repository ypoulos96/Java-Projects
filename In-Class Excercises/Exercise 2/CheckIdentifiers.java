/************************************************************
 *                                                          *
 *  CSCI 470/680     In-Class Exercise 2       Summer 2018  *                        
 *                                                          *
 *  Programmer:  Yiannis Poulos                             *
 *               Shaniel O Rivas Verdejo                    *
 *                                                          *
 *  Date Due:    The exercise due date goes here            *                          
 *                                                          *
 ************************************************************/
import java.io.*;

public class CheckIdentifiers
{
  public static void main(String [] args) throws IOException
  {
    char character;
    
    System.out.print("Please enter a valid Java identifier: ");
    
    character = (char)System.in.read();
    
    if (Character.isWhitespace(character))
    {
        System.out.println("At least one character is needed!");
    }
    
    else if (!Character.isLetter(character) && character != '_' && character != '$')
    {
      System.out.println("Illegal first charater: " + character);
    }
    
    else if (Character.isLetter(character) || character == '_' || character == '$') 
    {  
      
      System.out.println("Legal Identifier");
      
      do
      {
        character = (char)System.in.read();
        
        if (Character.isLetter(character) || Character.isDigit(character) || character == '$' || character == '_')
        {
          System.out.println("Legal Identifier");
        }
        
        else
        {
          System.out.println("Illegal character: " + character);
        }       
      }
      
      while (Character.isLetter(character) || Character.isDigit(character) || character == '$' || character == '_');
    }   
  }
}