/*
Name: Jonathan Guo
Period: 5th
Date: 9/4/19
What I learned
1. I learned how to add/subtracts coefficients together without going index out of bounds
2. I learned how to write the toString method by using a for loop to add each array value and print it out
3. I learned how to access info such as degree and coefficient by using the methods while coding add and subtract since the parameter was a Polynomial not an array

How I feel
I feel that I refreshed my memory on arrays and creating objects and that this lab helped me by forcing me to use a lot of logic to code the methods
 
Credits: 
*/
public class Pd5JonathanGuoArrayBasedPoly implements Polynomial
{
   private double [] arrayPoly;
   public Pd5JonathanGuoArrayBasedPoly (double [] a)
   {
      arrayPoly = a;
   }
   public Pd5JonathanGuoArrayBasedPoly (double coeff, int exp)
   {
      arrayPoly = new double [exp+1];
      for(int i = 0; i <= exp; i++)
      {
         if(i != exp)
         {
            arrayPoly[i] = 0;       //sets everything else to 0 except the correct coefficient and exponent
         }
         else
         {
            arrayPoly[i] = coeff;
         }
      }     
   }
   
   public Pd5JonathanGuoArrayBasedPoly (Polynomial copy)
   {
      arrayPoly = new double [copy.getDegree() + 1]; //copies all information from polynomial to the array
      for (int i = 0; i <= copy.getDegree(); i++)
      {
         arrayPoly[i] = copy.getCoeff (i);
      }
   }

   public int getDegree()
   {
      return arrayPoly.length - 1;              //accessor for degree
   }
   public double getCoeff(int x)
   {
      return arrayPoly[x];                      //accessor for coefficient
   }
   public double evaluate(double x)
   {
      int total = 0;
      for (int i = 0; i < arrayPoly.length; i++)                              
      {
         total += arrayPoly[arrayPoly.length - 1 - i] * Math.pow(x, arrayPoly.length - 1 - i);     //plugs in value for x into the polynomial
      }
      return total;
   }
   public Polynomial plus (Polynomial p)
   {
      double [] newArray;
      if (p.getDegree() > this.getDegree())
      {
         newArray = new double [p.getDegree() + 1];
         for (int i = 0; i <= this.getDegree(); i++)                    //adds coefficients together
         {
            newArray[i] = this.getCoeff(i) + p.getCoeff(i);
         }

         for (int i = this.getDegree() + 1; i <= p.getDegree(); i++)    //adds coefficient of the larger array since otherwise it would be an array index out of bounds error
         {
            newArray[i] = p.getCoeff(i);
         }
         //Here I tried to use a try catch but I could not figure out how to do it
         //Ex;
         /*
            try 
            {
               newArray[i] = this.getCoeff(i) + p.getCoeff(i);
            }
            catch (ArrayIndexOutofBoundsException e)
            {
            }
         */
      }
      else
      {
         newArray = new double [this.getDegree() + 1];
         for (int i = 0; i <= p.getDegree(); i++)
         {
            newArray[i] = p.getCoeff(i) + this.getCoeff(i);
         }
         for (int i = p.getDegree() + 1; i <= this.getDegree(); i++)
         {
            newArray[i] = this.getCoeff(i);
         }
      }
      Polynomial newP = new Pd5JonathanGuoArrayBasedPoly(newArray);   
      return newP;
   }
   public Polynomial minus (Polynomial p)
   {
      double [] newArray;
      if (p.getDegree() > this.getDegree())
      {
         newArray = new double [p.getDegree() + 1];
         for (int i = 0; i <= this.getDegree(); i++)
         {
            newArray[i] = this.getCoeff(i) - p.getCoeff(i);                      //subtracts coefficients
         }
         for (int i = this.getDegree() + 1; i <= p.getDegree(); i++)
         {
            newArray[i] = p.getCoeff(i);
         }
      }
      else
      {
         newArray = new double [this.getDegree() + 1];
         for (int i = 0; i <= p.getDegree(); i++)
         {
            newArray[i] = this.getCoeff(i) - p.getCoeff(i);
         }
         for (int i = p.getDegree() + 1; i <= this.getDegree(); i++)
         {
            newArray[i] = this.getCoeff(i);
         }
      }
      Polynomial newP = new Pd5JonathanGuoArrayBasedPoly(newArray);
      return newP;
   }

   public Polynomial differentiate()
   {
      double[] derive = new double [arrayPoly.length - 1];
      for (int i = 1; i <= derive.length; i++)
      {
         if(i == 1)
         {
            derive[i - 1] = arrayPoly[i];                //derivative of first degree polynomial is just coefficient
         }
         else
         {
            derive[i - 1] = i * arrayPoly[i];            //multiplies coefficient by degree and moves down an index
         }
      }
   
      Polynomial derivedPoly = new Pd5JonathanGuoArrayBasedPoly(derive);
      return derivedPoly;
   
   }
   
   public String toString ()
   {
      String s = "";
      for (int i = arrayPoly.length - 1; i >= 0; i--)    //run through each index and add it to the string
      {
         if (arrayPoly [i] == 0)
         {
         }
         else if (i == arrayPoly.length - 1)  
         {
            s += arrayPoly[i] + "x^" + i;
         } 
         else if(i == 0)
         {
            s += " + " + arrayPoly[i] + "";
         }
         else if(i == 1)
         {
            s += " + " + arrayPoly[i] + "x";
         }
         else
         {      
            s += " + " + arrayPoly[i] + "x^" + i;
         }
      } 
      return s; 
   }
}

/*
Output:

 
  ----jGRASP exec: java Pd5JonathanGuoArrayBasedPolyDriver
 p1(x) =     4.0x^3 + 3.0x^2 + 1.0
 p2(x) =     -5.0x^1 + -2.0
 p3(x) =     -4.0x^1
 p(x) =     4.0x^3 + 3.0x^2 + -10.0x + -3.0
 p4(x) =     4.0x^3 + 3.0x^2 + -6.0x + -3.0
 p5(x) =     12.0x^2 + 6.0x + -6.0
 clone(x) =     12.0x^2 + 6.0x + -6.0
 p5(0) = -6.0
 p5(1) = 12.0
 
  ----jGRASP: operation complete.
 
 
 */