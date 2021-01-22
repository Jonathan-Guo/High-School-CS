/**
Name: Jonathan Guo
Due: 9/24/19
Date Submitted: 9/24/19
What I learned:  
 - I learned how to write the copy constructor, make multiple ListNodes that point to the same list and copy data from another list
 - I learned how to write the multiply method to use a nested for loop and multiply one value by every value in the other list, then increment
 - I learned how to write the minus method by changing the sign of the other list and calling plus     
How I feel about this lab: 
 - I feel like this lab was definitely challenging to me but I was able to practice more ListNode syntax and coding with Singly Linked Lists. I
   feel that I have gotten pretty comfortable with Singly Linked Lists now because of SLL Lab #1 and this lab   
What I wonder: 
 - I wonder why people would ever use singly linked lists when you can just use doubly linked list so the pointers are much easier to deal with
Credits (person/websites and which part of your lab you got help from):  
   https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
   - This site helped me learn the logic to add two numbers from different lists together
      - Then all I did was add a loop to add all the values together 

Students I helped:
   I did not help anyone on this lab
**/

import java.lang.Math;

interface Polynomial{   
   Polynomial plus(Polynomial other);
   
   Polynomial minus(Polynomial other);
   
   Polynomial multiply(Polynomial other);
   
   Polynomial derivative ();
   double evaluate(double x);

}

public class Pd5GuoJonathanSinglyLinkedPolynomial implements Polynomial
{      
   private class ListNode<Term>
   {  
      private Term value;
      private ListNode<Term> next;
   
      public ListNode(Term t, ListNode<Term> n)
      {
         value = t;
         next = n;
      }
      
      public Term getValue()
      {
         return value;
      }
      
      public ListNode<Term> getNext()
      {
         return next;
      }
      
      public void setValue(Term newTerm)
      {
         value = newTerm;
      }
      
      public void setNext(ListNode<Term> n)
      {
         next = n;
      }
   }  //end of ListNode<Term>  
   
   private static class Term
   {
      private double exponent;
      private double coeff;
      
      public Term(double c, double e)
      {
         exponent = e;
         coeff = c;
      }
   
      public double getExponent()
      {
         return exponent;
      }
     
      public double getCoeff()
      {
         return coeff;
      }
     
      public void setExponent(double x)
      {
         exponent = x;
      }
     
      public void setCoeff(double x)
      {
         coeff = x;
      }
   
      public boolean equals(Term other)
      {
         return this.coeff == other.getCoeff() && this.exponent == other.getExponent();
      }
   
      public String toString()
      {
         return coeff + "x^" + exponent;
      }
   }  // Term 

   
   private ListNode<Term> head;
   
   public Pd5GuoJonathanSinglyLinkedPolynomial(double[] terms)
   {
      {
         if(terms == null)
            head = null;
         else {
            head = new ListNode<>(new Term(terms[0], terms[1]), null);
            ListNode<Term> temp = head;
            for (int i = 2; i < terms.length - 1; i = i + 2) {
               temp.setNext(new ListNode<>(new Term(terms[i], terms[i + 1]), null));
               temp = temp.getNext();
            }
         }
      }
   }
   
   public Pd5GuoJonathanSinglyLinkedPolynomial(ListNode<Term> x)
   {
      head = new ListNode<Term>(new Term (x.getValue().getCoeff(),x.getValue().getExponent()), null);
      x=x.getNext();
      for(ListNode<Term> temp=head;x!=null;x=x.getNext(),temp=temp.getNext()){
         Term t = new Term(x.getValue().getCoeff(),x.getValue().getExponent());
         temp.setNext(new ListNode<Term>(t,null));
      }
   }
   
   public Pd5GuoJonathanSinglyLinkedPolynomial()
   {
      head = null;
   }    //default
   
   //copy constructor
   public Pd5GuoJonathanSinglyLinkedPolynomial(Polynomial p)
   {     
         Pd5GuoJonathanSinglyLinkedPolynomial copy = (Pd5GuoJonathanSinglyLinkedPolynomial)(p);      //type casts Polynomial p
         ListNode <Term> copyTerms = copy.getHead();    //creates ListNode for p
      
         head = copyTerms;    //sets instance variable to copyTerms 
         ListNode <Term> temp = head;    
      
         for(copyTerms = copyTerms.getNext(); copyTerms != null; temp = temp.getNext(), copyTerms = copyTerms.getNext())
         {
            temp.setNext(new ListNode <Term> (new Term(copyTerms.getValue().getCoeff(), copyTerms.getValue().getExponent()), null)); //sets next value in temp to value in copyTerms
         }

   }
   
   public ListNode<Term> getHead()
   {
      return head;
   }
   
   public void setHead(ListNode <Term> node)
   {
      head = node;
   }
   
   /**
   pre-condition: this is not null
   post-condition: returns a double that is the answer if parameter x is plugged in as x
                   in the polynomial
   **/
   public double evaluate(double x)
   {    
      {
         double total = 0.0;
         ListNode<Term> temp = head;
         while(temp.getNext() != null)
         {
            total += (temp.getValue().coeff *(Math.pow(x, temp.getValue().exponent)));
            temp = temp.getNext();
         }
         return total;
      }   
   }
   
   /**
   pre-condition: this and other are not null
   post-condition: returns a Pd5GuoJonathanSinglyLinkedPolynomial that is the sum of this and other and
                   is in highest to lowest exponent order
   **/   
   public Polynomial plus(Polynomial other)
   {
      {
         Pd5GuoJonathanSinglyLinkedPolynomial endPoly = new Pd5GuoJonathanSinglyLinkedPolynomial(this);
         ListNode<Term> endList = endPoly.getHead();
         Pd5GuoJonathanSinglyLinkedPolynomial poly = (Pd5GuoJonathanSinglyLinkedPolynomial)(other);
         ListNode <Term> otherTerms = poly.getHead();
         ListNode <Term> temp;
      
         if(endList.getValue().getExponent() < otherTerms.getValue().getExponent())  //checks which List is larger and sets temp to the larger list
         {
            temp = otherTerms;
            otherTerms = endList;
            endList = temp;
         }
         else if(endList.getValue().getExponent() == otherTerms.getValue().getExponent())
         {
            endList.getValue().setCoeff(endList.getValue().getCoeff() + otherTerms.getValue().getCoeff());
            otherTerms = otherTerms.getNext();
            temp = endList;
         }
         else
         {
            temp = endList;
         }
      
         for (;temp.getNext() != null; temp = temp.getNext())
         {
            if(otherTerms == null) 
            {
               return endPoly;
            }
                     
            if(temp.getNext().getValue().getExponent() == otherTerms.getValue().getExponent()) //adds coefficients together with same exponent
            {
               temp.getNext().getValue().setCoeff(temp.getNext().getValue().getCoeff() + otherTerms.getValue().getCoeff());
               otherTerms = otherTerms.getNext();
            }
            else if(temp.getNext().getValue().getExponent() < otherTerms.getValue().getExponent()) //adds value from otherTerms to temp since exponent of otherTerms is larger and cannot compare coefficients
            {
               temp.setNext(new ListNode <Term> (otherTerms.getValue(), temp.getNext()));
               otherTerms = otherTerms.getNext();
            }
         }
         for(;otherTerms != null; otherTerms = otherTerms.getNext())
         
            temp.setNext(new ListNode <Term> (otherTerms.getValue(), null));
      
         return endPoly; 
      }
   }
   
   /**
   pre-condition: this and other are not null
   post-condition: returns a Pd5GuoJonathanSinglyLinkedPolynomial that is the difference of this and other and is
                   in highest to lowest exponent order
   **/   
   public Polynomial minus(Polynomial other)
   {
      Pd5GuoJonathanSinglyLinkedPolynomial copy = new Pd5GuoJonathanSinglyLinkedPolynomial(other);
      ListNode<Term>temp=copy.getHead();
      while (temp!=null)
      {
         temp.getValue().setCoeff(-temp.getValue().getCoeff());       //turns value of other Polynomials negative
         temp=temp.getNext();
      }
      return (plus(copy)); //adds a negative, same as subtracting
   }
   
   /**
   pre-condition: this is not null
   post-condition: returns a Pd5GuoJonathanSinglyLinkedPolynomial that is the derivative of this and is
                   in highest to lowest exponent order
   **/
   public Polynomial derivative()
   {
      Pd5GuoJonathanSinglyLinkedPolynomial copy = new Pd5GuoJonathanSinglyLinkedPolynomial(head);
      ListNode<Term>temp = copy.getHead();
      Term term;
       
      for(temp=copy.getHead();temp!=null;temp=temp.getNext())
      {
         temp.setValue(new Term(temp.getValue().getExponent()*temp.getValue().getCoeff(),temp.getValue().getExponent()-1));   //carries the exponent down and multiplies with coefficient, reduces exponent
      }
      return copy;   
   }
   

   /**
   pre-condition: this and other are not null
   post-condition: return a new Pd5GuoJonathanSinglyLinkedPolynomial in highest to lowest degree order
                   that is the product of this and other
   **/    
   
   public Polynomial multiply(Polynomial other)
   {
      Pd5GuoJonathanSinglyLinkedPolynomial otherPoly = (Pd5GuoJonathanSinglyLinkedPolynomial)(other);
      Polynomial endPoly = null;
      Polynomial newPoly;
      Term temp;
      for(ListNode <Term> outerTemp = head; outerTemp != null; outerTemp = outerTemp.getNext())    //loops through this list and multiplies every value in this list by every value in other list before incrementing
      {
         for(ListNode <Term> innerTemp = otherPoly.getHead(); innerTemp != null; innerTemp = innerTemp.getNext()) //loops thorugh each value in other list
         {
            temp = new Term(outerTemp.getValue().getCoeff() * innerTemp.getValue().getCoeff(), outerTemp.getValue().getExponent() + innerTemp.getValue().getExponent());
            if(endPoly == null)
            {
               endPoly = new Pd5GuoJonathanSinglyLinkedPolynomial(new ListNode <Term> (temp, null));
            }
            else
            {
               newPoly = new Pd5GuoJonathanSinglyLinkedPolynomial(new ListNode <Term> (temp, null));
               endPoly = endPoly.plus((Polynomial)(newPoly));
            }
         }
      }
      return endPoly;
   }

   
   //pre: none
   //post: returns the polynomial as a string
   public String toString()
   {
      {
         String polynomial = "";
         boolean isFirst = true;
         for(ListNode<Term> x = head; x != null; x = x.next)
         {
            double coeff = x.getValue().getCoeff();
            double exponent = x.getValue().getExponent();
            if (isFirst)
            {
               polynomial += coeff + "x^" + exponent + " ";
               isFirst = false;
            }
            else
            {
               if (exponent == 0)
               {
                  if (coeff < 0)
                  {
                     polynomial += " - " + (coeff*-1);
                  }
                  else
                  {
                     polynomial  += " + " + coeff ;
                  }
                  break;
               }
               if (coeff < 0)
               {
                  polynomial += " - " + (coeff*-1) + "x^" + exponent + " ";
               }
               else
               {
                  polynomial  += " + " + coeff + "x^" + exponent + " ";
               }
            }
              
         }
         return polynomial;
      }
   
   }
   public static void main(String[] args)  
   {
      double[] arr = {4,3,3,2,1,0};
      Polynomial p1 = new Pd5GuoJonathanSinglyLinkedPolynomial(arr);  // 4x^3 + 3x^2 + 1
      System.out.println("p1(x) =     " + p1);
   
      double[] arr2 = {-5,1,-2,0};
      Polynomial p2 = new Pd5GuoJonathanSinglyLinkedPolynomial(arr2);   // - 5x – 2
      System.out.println("p2(x) =     " + p2);                 // p2(x) = - 5x^1 – 2
      System.out.println("p1 and p2 are the same: " + p1.equals(p2));
      
      double[] arr3 = {-4,1};
      Polynomial p3   = new Pd5GuoJonathanSinglyLinkedPolynomial(arr3);  // coeff, exp = -4x
      System.out.println("p3(x) =     " + p3);
   
      Polynomial p    = p1.plus(p2).plus(p2);   // 4x^3 + 3x^2 - 10x – 3
      System.out.println("p(x)  =     " + p);       // p(x) = 4x^3 + 3x^2 - 10x^1 – 3
   
      Polynomial p4   = p.minus(p3);   // 4x^3 + 3x^2 - 6x^1 – 3   <====
      System.out.println("p4(x) =     " + p4);
   
      Polynomial p5   = p4.derivative();   // 12x^2 + 6x^1 - 6   <====
      System.out.println("p5(x) =     " + p5);
            
      Polynomial clone = new Pd5GuoJonathanSinglyLinkedPolynomial(p5);
      System.out.println("clone(x) =     " + clone);
      System.out.println("p5 and clone are the same: " + p5.equals(clone));
      
      Polynomial clone2 = p5;
      System.out.println("clone2(x) =    " + clone2);
      System.out.println("p5 and clone 2 are the same: " + p5.equals(clone2));
      
      Polynomial product = p1.multiply(p2);
   
      System.out.println("product of p1(x) and p2(x) is     " + product);
      
      System.out.println ("p5(0) = " + p5.evaluate(0));
      System.out.println ("p5(1) = " + p5.evaluate(1));
   }
}  //end of SinglyLinkedPolynomial

/*
Outputs:
 
 
  ----jGRASP exec: java Pd5GuoJonathanSinglyLinkedPolynomial
 p1(x) =     4.0x^3.0  + 3.0x^2.0  + 1.0
 p2(x) =     -5.0x^1.0  - 2.0
 p1 and p2 are the same: false
 p3(x) =     -4.0x^1.0 
 p(x)  =     4.0x^3.0  + 3.0x^2.0  - 10.0x^1.0  - 3.0
 p4(x) =     4.0x^3.0  + 3.0x^2.0  - 6.0x^1.0  - 3.0
 p5(x) =     12.0x^2.0  + 6.0x^1.0  - 6.0
 clone(x) =     12.0x^2.0  + 6.0x^1.0  - 6.0
 p5 and clone are the same: false
 clone2(x) =    12.0x^2.0  + 6.0x^1.0  - 6.0
 p5 and clone 2 are the same: true
 product of p1(x) and p2(x) is     -20.0x^4.0  - 23.0x^3.0  - 6.0x^2.0  - 5.0x^1.0  - 2.0
 p5(0) = -6.0
 p5(1) = 12.0
 
  ----jGRASP: operation complete.
 
 

*/
