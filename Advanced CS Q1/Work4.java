public class Work4
{
   public static boolean elfish (String s)
   {
      return elfish (s, 0);
   }
   
   private static boolean checkE = false;
   private static boolean checkL = false;
   private static boolean checkF = false;
   
   public static boolean elfish (String s, int index)
   {
      if (s.substring(index, index + 1).equals("e"))
         checkE = true;
      else if (s.substring(index, index + 1).equals("l"))
         checkL = true;
      else if (s.substring(index, index + 1).equals("f"))
         checkF = true;
      if (index == s.length() - 1)
      {
         if (checkE && checkL && checkF )
         {
            return true;  
         }
         else
         {
            return false;
         }
      }
      else
      {
         return elfish (s, index + 1);
      }
   }
   public static boolean xIsh(String s1, String s2) 
   {
      if (s1.length() == 0) 
         return true;
      if (s2.length() == 0)
         return false;
         
      String first = s1.substring(0, 1);
      if (s2.contains(first)) 
         return xIsh(s1.substring(1),s2);
      else 
         return false;
   } 
}