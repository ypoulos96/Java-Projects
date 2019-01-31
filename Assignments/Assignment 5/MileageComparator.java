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

import java.util.*;

public class MileageComparator implements Comparator<Destination> 
{
  /**********************************************************************************
  *   compare(): sorts destination objects in decending order by noamal miles       *      
  **********************************************************************************/
   public int compare(Destination d1, Destination d2) 
   {
      return (d2.getNormalMiles() - d1.getNormalMiles());
   }
}
