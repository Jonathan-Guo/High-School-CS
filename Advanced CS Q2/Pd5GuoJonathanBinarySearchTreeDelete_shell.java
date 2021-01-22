 /*****************************************************************************************************************
NAME: Jonathan Guo      
PERIOD: 5
DUE DATE: 1/24/2020 

PURPOSE: Learn how to write the delete method

WHAT I LEARNED:    
- I learned how to check the first 2 conditions and how to delete them
- I learned how to set the parents next pointer to null by checking if the child was on the elft or right subtree
HOW I FEEL ABOUT THIS LAB:
- I do not feel too confident because I could not get my code to work after a lot of time trying. I feel fine about the first two conditions, and how deleting works.
  I just couldn't make the last condition work.
            
CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITES && what kind of 
         help did you get from the source?): None

****************************************************************************************************************/
import java.util.Scanner;
/****************************************************************
Practice with a Binary Search Tree. Uses TreeNode.
Step 1: Prompt the user for an input string.  
Step 2: Build a Binary Search Tree using Comparables.  
Step 3: Display it as a sideways tree (take the code from TreeLab).  
Step 4: Prompt the user for a target and delete that node, if it exists. 
*****************************************************************/
public class Pd5GuoJonathanBinarySearchTreeDelete_shell
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Input string: ");
      String s = sc.nextLine();   // Use	ECSBPWANR
   	         				   							    
      TreeNode t = null;
      for(int x = 0; x<s.length(); x++)
         t = insert(t, s.substring(x, x+1));
      display(t, 0);
   
      while (true)
      {
         System.out.print("Delete? ");
         String target = sc.next();
         if( contains( t, target ) )
         {
            t = delete( t, target );
            System.out.println("\n" + target+" deleted.");
         }
         else
            System.out.println("\n" + target+" not found");
         display(t, 0);   
      }     
   }
   
	/**************************
	Recursive algorithm to build a BST:  if the node is null, insert the 
	new node.  Else, if the item is less, set the left node and recur to 
	the left.  Else, if the item is greater, set the right node and recur 
	to the right.   
	*****************************/
   public static TreeNode insert(TreeNode t, String s)
   {  	
      if(t==null)
         return new TreeNode(s);
      if(s.compareTo(t.getValue()+"")<0)
         t.setLeft(insert(t.getLeft(), s));
      else
         t.setRight(insert(t.getRight(), s));
      return t;
   }
   public static void display(TreeNode t, int level)
   {
      if(t == null)
         return;
      display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         System.out.print("\t");
      System.out.println(t.getValue());
      display(t.getLeft(), level + 1); //recurse left
   }
   
   public static boolean contains( TreeNode current, String target )
   {
      while(current !=null)
      {
         int compare = target.compareTo((String)current.getValue());
         if( compare == 0 )
            return true;
         else if(compare<0)
            current = current.getLeft();
         else if(compare>0)
            current = current.getRight();
      }
      return false;
   }
   public static TreeNode delete(TreeNode current, String target)
   {
      TreeNode root = current;
      TreeNode parent = null;
      while(current !=null)
      {
         int compare = target.compareTo((String)current.getValue());
         if (compare < 0)
         {
            parent = current;
            current = current.getLeft();
         }
         else if (compare > 0)
         {
            parent = current;
            current = current.getRight();
         }
         else
         {
            if (current.getLeft() == null && current.getRight() == null)
            {
               if (parent.getRight() == current)
                  parent.setRight (null);
               else
                  parent.setLeft (null);
               return root;
            }
            else if (current.getLeft() != null && current.getRight() == null)
            {
               parent.setLeft(current.getLeft());
               return root;
            }
            else if (current.getLeft() == null && current.getRight() != null)
            {
               parent.setRight(current.getRight());
               return root;
            }
            else
            {
               TreeNode temp = current.getLeft();     //Could not figure out how to get this part of code to work. It just swaps the values but does not delete the original node.
               while (temp.getRight() != null)
               {
                  temp = temp.getRight();
               }
               Object var = current.getValue();
               current.setValue(temp.getValue());
               temp.setValue(var);
               current = delete(current, target);    
               return root;             
            }
         }
        
        
      }
      return root;  //never reached
   } // end of delete
}  // end of class

/*  Sample Runs

 Input string: ECSBPWANR
 		W
 	S
 			R
 		P
 			N
 E
 	C
 		B
 			A
 Delete? A
 
 A deleted.
 		W
 	S
 			R
 		P
 			N
 E
 	C
 		B
 Delete? E
 
 E deleted.
 		W
 	S
 			R
 		P
 			N
 C
 	B
 Delete? S
 
 S deleted.
 		W
 	R
 		P
 			N
 C
 	B
 Delete? N
 
 N deleted.
 		W
 	R
 		P
 C
 	B
 Delete? 


*/