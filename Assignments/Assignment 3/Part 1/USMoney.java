public class USMoney
{
  private int dollars;
  private int cents;
  
  /****************************************
  *     Constructor for USMoney class     *  
  ****************************************/
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
  
  /************************************
  *    Get total amount of dollars    *
  ************************************/
  public int getDollars()
  {
    return dollars;
  }
  
  /************************************
  *     Get total amount of cents     *
  ************************************/
  public int getCents()
  {
    return cents;
  }
  
  /************************************
  *   Add 2 USMoney objects together  *
  ************************************/
  public USMoney plus(USMoney a)
  { 
    int sumDollars = getDollars() + a.getDollars();
    
    int sumCents = getCents() + a.getCents();
    
    USMoney c = new USMoney(sumDollars, sumCents);
      
    return c;
  }
}





