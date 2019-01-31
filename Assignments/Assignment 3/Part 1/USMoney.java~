/**********************************************************
 *                                                        *
 *  CSCI 470/680-E       Assignment 3        Summer 2018  *
 *                                                        *
 *  Developer(s):  Yiannis Poulos                         *
 *                 (include team members’ names too)      *
 *                                                        *
 *  Section:  2                                           *
 *                                                        *
 *  Due Date/Time:  7/3/18 at 11:59pm                     *
 *                                                        *
 *  Purpose:  A brief description of what the entire      *
 *            application does goes here.                 *
 *                                                        *
 **********************************************************/

public class USMoney
{
  private int dollars;
  private int cents;
  
  public USMoney(int startDollars, int startCents)
  {
    dollars = startDollars;
    cents = startCents;
    
    if (startCents < 0 || startCents > 99)
    {
      dollars += (startCents / 100); 
      cents = (startCents % 100);
    }
  }
  
  public int getDollars()
  {
    return dollars;
  }
   
  public int getCents()
  {
    return cents;
  }
  
  public USMoney plus(USMoney a)
  { 
    int sumDollars = getDollars() + a.getDollars();
    
    int sumCents = getCents() + a.getCents();
    
    USMoney c = new USMoney(sumDollars, sumCents);
      
    return c;
  }
}





