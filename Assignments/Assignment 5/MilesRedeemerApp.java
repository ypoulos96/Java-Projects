/***********************************************************
*                                                          *
*  CSCI 470/680      Assignment 5            Summer 2018   *
*                                                          *
*  Programmer: Yiannis Poulos                              *
*              Shaniel Omar Rivas Verdejo                  *
*                                                          *
*  Section:    2                                           *
*                                                          *
*  Date Due:   07/30/2018                                  *
*                                                          *
*  Purpose:    This program provides a Graphical User      *
*              Interface of a list of possible travel      *
*              destinations for a client who wishes        *
*              to redeem their accumulated frequent        *
*              flyer miles.                                *
*                                                          *
***********************************************************/

import javax.swing.JFrame; 
import java.io.IOException;

public class MilesRedeemerApp
{
  public static void main(String[] args) throws IOException
  {
    MilesRedeemerFrame milesRedeemerFrame = new MilesRedeemerFrame();
    
    milesRedeemerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    milesRedeemerFrame.setSize(700, 460); 
    milesRedeemerFrame.setResizable(false);
    milesRedeemerFrame.setVisible(true);  
  }                                        
}