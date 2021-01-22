/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: EMail
Purpose of Program: Identify the username, host name, and extension when given the email address

What I learned: 
- I learned how to use the substring method effectively to return the chars from a certain range of position
- I learned how to use indexOf to find the index of a certain character
******************************************************************/

public class EMail
{
   private String myUserName;
   private String myHostName;
   private String myExtension;
   public EMail (String address)
   {
      myUserName = address.substring (0, address.indexOf ("@")); 
      myHostName = address.substring (address.indexOf ("@") + 1, address.indexOf ("."));
      myExtension = address.substring (address.indexOf (".") + 1); 
   }
   public String getUserName ()
   {
      return myUserName;
   }
   public String getHostName ()
   {
      return myHostName;
   }
   public String getExtension ()
   {
      return myExtension;
   }
   public String toString ()
   {
      return "Username: " + myUserName + "\nHost Name: " + myHostName + "\nExtenstion: " + myExtension + "\n";
   }
   public static void main (String [] args)
   {
      EMail Jonathan = new EMail ("Jonny888@gmail.com");
      EMail mrLau = new EMail ("Lau123@fcps.edu");
      System.out.println (Jonathan);
      System.out.print (mrLau);
   }
}

/*
Outputs:
 
  ----jGRASP exec: java EMail
 Username: Jonny888
 Host Name: gmail
 Extenstion: com
 
 Username: Lau123
 Host Name: fcps
 Extenstion: edu
 
  ----jGRASP: operation complete.
 

*/