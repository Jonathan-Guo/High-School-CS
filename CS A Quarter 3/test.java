public class test 
{
   public static void main (String [] args)
   {
      int [][] arr = new int [5][10];
      int count = 0;
      for (int i = 0; i < arr[0].length; i++)
      {
         System.out.print ((count + i)*10 + "\t");
         if (i == 9)
         {
            i = -1;
            count++;
            System.out.println();
         }
         if (count == 5)
         {
            break;
         }
      }
   }
}