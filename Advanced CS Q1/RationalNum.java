/*
Name: Jonathan Guo
Period: 5th
Date: 8/26/19
What I learned
1. I learned the logic behind the simplify method to check if the numerator and denominator had any of the same factors and then divided them by that common factor
2. I relearned how to write the equals method to simplify the fractions first and then check if they were equal
3. I learned the logic behind the add and subtract method to cross multiply the fractions so that I could add and subtract the fractions correctly

How I feel
I feel good about this course and glad that I could use this lab to refresh my memory about syntax and just practice coding again for the first time in a while.
 
Credits: 
*/

public class RationalNum {

   private int num;
   private int denom;
	
	//Constructor method
	//Pre:
	//Post: sets instance variables
   public RationalNum(int num, int denom) 
   {
      this.num = num;
      this.denom = denom;
   }
	
	//copy constructor
	//Pre: copy is not null
	//Post: creates a copy of copy param
   public RationalNum(RationalNum copy) 
   {
      this.num = copy.num;
      this.denom = copy.denom;
   }
	
	//Post: returns numerator
   public int getNum() 
   {
      return num;   
   }
	
	//Post: returns denominator
   public int getDenom() 
   {
      return denom;
   }
	
	//Pre:  numer is a int
	//Post: sets numerator to newNumer
   public void setNum(int newNum) 
   {
      num = newNum;      
   }
	
	//Post: sets denominator to newDenom
   public void setDenom(int newDenom) 
   {
      denom = newDenom;
      if (denom == 0)
         System.out.print ("Cannot set denominator to 0 ");   
   }
	
	//Simplifies a rational number
   public static RationalNum simplify(RationalNum param) 
   {   
      if (param.getDenom() > param.getNum())
      {
         for (int i = 2; i < param.getNum(); i++)
         {
            if (param.getNum() % i == 0 && param.getDenom() % i == 0)   //check if numerator and denominator have any same factor
            {
               param.setNum (param.getNum() / i);
               param.setDenom (param.getDenom() / i);                   //divide by common factor if there is one
               i = 1;                                                   
            }  
         } 
      }
      else
      {
         for (int i = 2; i < param.getDenom(); i++)
         {
            if (param.getNum() % i == 0 && param.getDenom() % i == 0)
            {
               param.setNum (param.getNum() / i);
               param.setDenom (param.getDenom() / i);
               i = 1;
            }  
         } 
      }
      return param;
   }
	
	//Pre:  other is defined correctly
	//Post: adds both RationalNums and returns that RationalNum
   public RationalNum add(RationalNum other) 
   {
      int num = getNum() * other.getDenom() + getDenom() * other.getNum();   //cross multiply so you can add
      int denom = getDenom() * other.getDenom();                             //same denomiator
      RationalNum var = new RationalNum (num, denom);
      simplify (var);
      return var;
   }
	
	//Pre:  other is defined correctly
	//Post: subtracts both RationalNums and returns that RationalNum
   public RationalNum subtract(RationalNum other) 
   {
      int num = getNum() * other.getDenom() - getDenom() * other.getNum();
      int denom = getDenom() * other.getDenom();
      RationalNum var = new RationalNum (num, denom);
      simplify (var);
      return var;
   }
	
	//Pre:  other is defined correctly
	//Post: multiples both RationalNums and returns that RationalNum
   public RationalNum multiply(RationalNum other) 
   {
      int num = getNum() * other.getNum();
      int denom = getDenom()* other.getDenom();
      RationalNum var = new RationalNum (num, denom);
      simplify (var);
      return var;
   }
	
	//Pre:  other is defined correctly and has nonzero numerator
	//Post: divides both RationalNums and returns that RationalNum
   public RationalNum divide(RationalNum other)
   {
      int num = getNum() * other.getDenom();
      int denom = getDenom() * other.getNum();
      RationalNum var = new RationalNum (num, denom);
      simplify (var); 
      return var;  
   }
	
	//Pre:  both RationalNums are defined correctly
	//Post: returns whether this is the same as param
   public boolean equals(RationalNum other) 
   {
      RationalNum s = new RationalNum(this.getNum(), this.getDenom()); 
      s = simplify(s);
      other = simplify(other);   //simplify both of the fractions
      
      return s.getNum() == other.getNum() && s.getDenom() == other.getDenom(); //see if the fractions are equal
   }
	
	//toString method
	//returns a String representing a RationalNum
   public String toString() 
   {
      return num + "/" + denom;
   }
	
   public static void main(String [] args) {
      RationalNum r1 = new RationalNum(52, 36);
      System.out.println("r1 = " + r1);
      System.out.println("r1 simplified = " + simplify(r1));
   	
      RationalNum r2 = new RationalNum(7, 39);
      r2.setDenom(0);
      System.out.println("r2 = " + r2 + "\n");
      r2.setDenom(14);
      System.out.println("r2 = " + r2 + "\n");
      System.out.println("r1 + r2: " + r1.add(r2));
      System.out.println("r1 - r2: " + r1.subtract(r2));
      System.out.println("r1 * r2: " + r1.multiply(r2));
      System.out.println("r1 / r2: " + r1.divide(r2));
      System.out.println("r1 equals r2: " + r1.equals(r2));
   	
   }
}

/*Outputs:
 
  ----jGRASP exec: java RationalNum
 r1 = 52/36
 r1 simplified = 13/9
 Cannot set denominator to 0 r2 = 7/0
 
 r2 = 7/14
 
 r1 + r2: 35/18
 r1 - r2: 17/18
 r1 * r2: 13/18
 r1 / r2: 26/9
 r1 equals r2: false
 
  ----jGRASP: operation complete.
 

*/ 