public class Triangle
{
   private double s1, s2, s3;
   public Triangle (double s1, double s2, double s3) throws IllegalTriangleException
   {
      this.s1 = s1;
      this.s2 = s2;
      this.s3 = s3;   
      if (s1 + s2 < s3 || s1 + s3 < 2 || s2 + s3 < s1)
      {
         throw new IllegalTriangleException ();
      }
   }
}

class IllegalTriangleException extends Exception
{
   public IllegalTriangleException ()
   {
      super ();
   }
}