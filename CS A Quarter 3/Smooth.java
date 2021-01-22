/*  Must fill this out with thoughtful reflection. Not completing
    this section will lose 10% of your grade.
    
Name: Jonathan Guo
Period: 8
Lab: Image Smoother
Purpose: To smooth values of an image by replacing each element with the average of the elements surrounding it
Due date: 12 March, 2019
What I learned:
   a. How to use 1D arrays to store the value of the smoothed row
   b. How to check if the index is out of bounds
   c. How to smooth a row by using for loops to check for the 9 surrounding values in the 2D array
   d. To put the smoothed 1D array row before the second nested for loop so that it changes the values of the 2D array rows one row at a time
   e. To increment total and change value of sum to calculate the smoothed values for each row
Credits: https://stackoverflow.com/questions/652106/finding-neighbours-in-a-two-dimensional-array
Used this website to help me understadn the logic to check for the neighbors of a 2D array in order to increment the total value
*/

public class Smooth
{
   public static void main ( String[] args ) 
   {
      int[][] image  = { {1,2,3,4,5,6},
                         {2,5,5,5,5,5},
                         {3,5,5,5,5,4},
                         {4,5,5,5,5,3},
                         {5,5,5,5,5,2},
                         {6,5,4,3,2,1}
                       };
      printImage (image);  
      smoothImage (image); 
      printImage(image);
   
      // Use Math.random to create a 5x5 2D array
      // Value of each cell is from 6-20.
      int [][] smallImage = new int [4][4];
      createImage (smallImage);
      printImage (smallImage);
      smoothImage (smallImage);
      printImage (smallImage);
   
   } //end of main
   
   // precondition: All indexes of the 2D array have been instantiated to some value
   // postcondition: The image 2D array has been changed so that all its values are smoothed
   // NOTE: When writing this method, you are not permitted
   //       to use any auxiliary 2-D array. You can use a 1-D
   //       array.
   //       Must put comments in your program so that other
   //       people understand the logic of your method.
   public static void smoothImage (int [] [] image)
   {  
      int [] newRow = new int [image.length]; //creates 1D array to store values of each smoothed row
      for (int r = 0; r < image.length; r++)
      {
         newRow = smoothRow (image, r);
         for (int c = 0; c < image[0].length; c++)
            image[r][c] = newRow[c];
      }
   }  // end of smoothImage
   
   public static int [] smoothRow (int [] [] image, int r)
   {
      int [] newRow = new int [image[0].length]; //creates 1D array to story values of smoothed row
      int sum; int total; int c;
      for (c = 0; c < image[0].length; c++) //runs code until all the columns of the row have been checked
      {
         sum = 0; total = 0; 
         for (int i = r - 1; i <= r + 1; i++) //nested for loops to check all 9 of the surrounding values to be averaged for the new value
         {
            for (int j = c - 1; j <= c + 1; j++) 
            {
               if (i > -1 && i < image.length && j > -1 && j < image[0].length) //only adds values to sum and total that are actually in the array, checks for index out of bound
               {
                  sum += image[i][j];
                  total++; 
               }
            }
         }
         newRow[c] = sum/total;      
      } 
      return newRow;
   }
    
   // precondition: 2-D array has values in it
   // postcondition: Prints out all the values in the 2-D array by row
   public static void printImage (int [] [] image)
   {
      for (int r = 0; r < image.length; r++)
      {
         for (int c = 0; c < image[0].length; c++)
            System.out.print (image[r][c] + " ");
         System.out.println ("");
      }
      System.out.println ("");
                
   } // print
   
   // precondition: 2-D array has been instantiated
   // postcondition: Assigns each element of the 2D - array to a random value from 6-20
   public static void createImage (int [] [] image)
   {
      for (int r = 0; r < image.length; r++)
         for (int c = 0; c < image[0].length; c++)
            image[r][c] = (int)(Math.random () * 14 + 6);
   }  // end of createImage
}  // end of Smooth

/*Outputs:
 
  ----jGRASP exec: java Smooth
 1 2 3 4 5 6 
 2 5 5 5 5 5 
 3 5 5 5 5 4 
 4 5 5 5 5 3 
 5 5 5 5 5 2 
 6 5 4 3 2 1 
 
 2 3 4 4 5 5 
 3 3 4 4 4 4 
 3 4 4 4 4 4 
 4 4 4 4 4 3 
 4 4 4 4 3 2 
 4 4 4 3 2 2 
 
 15 7 17 6 
 11 6 12 18 
 13 13 8 17 
 12 14 11 13 
 
 9 11 11 13 
 10 10 12 13 
 12 11 12 12 
 12 12 12 12 
 
 
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Smooth
 1 2 3 4 5 6 
 2 5 5 5 5 5 
 3 5 5 5 5 4 
 4 5 5 5 5 3 
 5 5 5 5 5 2 
 6 5 4 3 2 1 
 
 2 3 4 4 5 5 
 3 3 4 4 4 4 
 3 4 4 4 4 4 
 4 4 4 4 4 3 
 4 4 4 4 3 2 
 4 4 4 3 2 2 
 
 18 6 6 13 
 18 19 9 17 
 9 12 9 17 
 17 14 18 12 
 
 15 12 11 11 
 14 12 13 12 
 13 13 13 13 
 14 14 13 14 
 
 
  ----jGRASP: operation complete.
 


*/