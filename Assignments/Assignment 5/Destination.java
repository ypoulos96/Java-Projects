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

public class Destination
{
  private String city;
  private int normalMiles;
  private int cheapMiles;
  private int upgradeMiles;
  private int startMonth;
  private int endMonth;
  
  /***************************************************************************                                                                                                                                                       
  *        Destination(): The constructor for the destination class          *
  ****************************************************************************/
  
  public Destination(String city, String normalMiles, String cheapMiles, 
                     String upgradeMiles, String startMonth, String endMonth)
  {
    this.city = city;
    this.normalMiles = Integer.parseInt(normalMiles);
    this.cheapMiles = Integer.parseInt(cheapMiles);
    this.upgradeMiles = Integer.parseInt(upgradeMiles);
    this.startMonth = Integer.parseInt(startMonth);
    this.endMonth = Integer.parseInt(endMonth);
  }
  
  /***************************************************************************                                                                                                                                                                                                                                                 
  *         getCity(): returns the name of a destinations city               *                            
  ****************************************************************************/
  public String getCity()
  {
    return city;
  }
  
  /***************************************************************************                                                                              
  *        getNormalMiles(): returns the normal number of miles              *                                                                              
  ****************************************************************************/  
  public int getNormalMiles()
  {
    return normalMiles;
  }
  
  /*****************************************************************************
  * getCheapMiles(): returns the number of miles during the "Fly Cheap" period *       
  *****************************************************************************/ 
  public int getCheapMiles()
  {
    return cheapMiles;
  }
  
  /**********************************************************************************                                                                                                                                                                                                                                       
  * getUpgradeMiles(): returns the number of miles needed to upgrade to First Class *                                                                                
  **********************************************************************************/  
  public int getUpgradeMiles()
  {
    return upgradeMiles;
  }

  /**********************************************************************************                                                                                                                                                                                                                                               
  *     getStartMonth(): returns the starting month of the "Fly Cheap" period       *                                                                              
  **********************************************************************************/
  public int getStartMonth()
  {
    return startMonth;
  }

  /**********************************************************************************                                                                                                                                                                    
  *     getStartMonth(): returns the starting month of the "Fly Cheap" period       *                                                                               
  **********************************************************************************/
  public int getEndMonth()
  {
    return endMonth;
  }
  
}