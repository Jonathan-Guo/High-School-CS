// test client
public class Pd5JonathanGuoArrayBasedPolyDriver
{
   public static void main(String[] args) { 
      double [] c = {1, 0, 3, 4};
      double [] c1 = {-2, -5};
   
      Polynomial p1 = new Pd5JonathanGuoArrayBasedPoly(c);  // 4x^3 + 3x^2 + 1
      System.out.println("p1(x) =     " + p1);
   
      Polynomial p2 = new Pd5JonathanGuoArrayBasedPoly(c1);   // - 5x – 2
      System.out.println("p2(x) =     " + p2);                 // p2(x) = - 5x^1 – 2
   
      Polynomial p3 = new Pd5JonathanGuoArrayBasedPoly (-4, 1);  // coeff = -4, exp = 1
      System.out.println("p3(x) =     " + p3);
   
      Polynomial p    = p1.plus(p2).plus(p2);   // 4x^3 + 3x^2 - 10x – 3
      System.out.println("p(x) =     " + p);       // p(x) = 4x^3 + 3x^2 - 10x^1 – 3
   
      Polynomial p4   = p.minus(p3);   // 4x^3 + 3x^2 - 6x^1 – 3   <====
      System.out.println("p4(x) =     " + p4);
   
   
      Polynomial p5   = p4.differentiate();   // 12x^2 + 6x^1 - 6   <====
      System.out.println("p5(x) =     " + p5);
      
      Polynomial clone = new Pd5JonathanGuoArrayBasedPoly (p5);
      System.out.println("clone(x) =     " + clone);
   
      System.out.println ("p5(0) = " + p5.evaluate(0));
      System.out.println ("p5(1) = " + p5.evaluate(1));
   }
}
