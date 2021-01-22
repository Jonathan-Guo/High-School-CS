/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Drug Potency
Purpose: The purpose of this lab was to see how many months a drug can remain in storage 
if it is removed after the efficiency is below 50 and loses 4% efficiency every month.

What I learned: I learned that while loops such as this one can also be used very practically 
in the real world such as this example where you can identify how long a drug is effective for. 
I also learned how to embed an if statement inside of a while loop. 

******************************************************************/
public class Drug
{
   public static void main (String [] args)
   {
      int month = 0;
      double effectiveness = 100;
      while (effectiveness > 50.0)
      {
         System.out.println ("month: " + month + "\teffectiveness: " + effectiveness);
         month ++;
         effectiveness = effectiveness * .96;
         if (effectiveness < 50)
         {
            System.out.println ("month: " + month + "\teffectiveness: " + effectiveness + " DISCARDED");
         }
      }
   }
}

/*
Outputs:
 
  ----jGRASP exec: java Drug
 month: 0	effectiveness: 100.0
 month: 1	effectiveness: 96.0
 month: 2	effectiveness: 92.16
 month: 3	effectiveness: 88.47359999999999
 month: 4	effectiveness: 84.93465599999999
 month: 5	effectiveness: 81.53726975999999
 month: 6	effectiveness: 78.27577896959998
 month: 7	effectiveness: 75.14474781081599
 month: 8	effectiveness: 72.13895789838334
 month: 9	effectiveness: 69.253399582448
 month: 10	effectiveness: 66.48326359915008
 month: 11	effectiveness: 63.82393305518407
 month: 12	effectiveness: 61.27097573297671
 month: 13	effectiveness: 58.82013670365764
 month: 14	effectiveness: 56.46733123551133
 month: 15	effectiveness: 54.20863798609088
 month: 16	effectiveness: 52.04029246664724
 month: 17	effectiveness: 49.95868076798135 DISCARDED
 
  ----jGRASP: operation complete.
 
*/