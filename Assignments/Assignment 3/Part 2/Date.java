public class Date
{
  private int day;
  private int month;
  private int year;
  
  /*********************************************
  *     Constructor to initialize values       *
  * *******************************************/
  public Date(int startDay, int startMonth, int startYear)
  {
    startDay = day;
    startMonth = month;
    startYear = year;      
  }
  
  /*************************************************
  * Determines whether a given year is a leap year *
  **************************************************/
  public boolean isLeapYear(int x)
  {    
    if (x % 4 == 0)     //If the given value is divisible by 4...
    {
      if ( x % 100 == 0 && x % 400 != 0)    //...and the given value is divisible by 100 but not 400
        return false;                       //It is not a leap year
    
      else            //Otherwise
        return true;  //It is a leap year
    } 
    
    else           //If not divisible by 4
      return false;    //It is not a leap year
  }
  
  /**********************************************
  *  Calculates number of days since January 1  *
  **********************************************/
  public int daysSinceJan1(int dayNum, int monthNum, int yearNum)
  {
    int totalDays = 0;       //Holds total number of days
    int i = monthNum;        //Month counter
    
    totalDays += dayNum;     //increment total by total number of days
    
    while (i > 1)            //While the month is later than january...
    {
      i--;
      
      if (i % 2 == 0 && i != 2)       //if the month is even and not February...
      {
        if(i >= 8)                    //if month is equal to or later than August...
          totalDays += 31;            //add 31 days to total
        
        else
          totalDays += 30;            //otherwise add 31 days to total
      }
      
      else if (i % 2 == 1 && i != 2)  //if the month is odd and not February...
      {
        if(i <= 7)                    //and if the month is equal to earlier than July..
          totalDays += 31;            //add 30 days to total
        
        else
          totalDays += 30;            //otherwise add 30 days to total
      }
      
      else if (i == 2)                //if the month is February...
        totalDays += 28;              //add 28 days to total        
    }
     
    if (monthNum > 2 && isLeapYear(yearNum))  //If the month is later than February and it is a leap year
      totalDays += 1;                         //Increment total days by one    
    
    return totalDays - 1;         //return number of days passed excluding January 1
  }
}  