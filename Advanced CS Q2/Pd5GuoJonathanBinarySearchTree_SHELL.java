/*****************************************************************************************************************
NAME: Jonathan Guo     
PERIOD: 5
DUE DATE: 1/22/20 

PURPOSE: To learn about the methods in Binary Search Tree and how to find data in a Binary Search Tree

WHAT I LEARNED:   
- I learned in class that in the insert method you must say t.setLeft (insert()). I was able to apply it here to the lab.
- I learned how to do the find method recursively by returning the right or left subtree depending on the Comparable value. This also helped me see how the Big O is logn
- I learned that the min and max methods are much easier in BST because they will be on the far left or far right of the tree respectively
- I learned how to print the values small to large by printing the far left of the subtree first with recursion and essentially movinf your way backwards

HOW I FEEL ABOUT THIS LAB: 
- I feel pretty good about this lab and recognize that it is easier to access data with a Binary Search Tree than just a regular Binary Tree. However,
  I was a bit confused why my find method iteratively did not work. 
            
CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITE): None

****************************************************************************************************************/
import java.util.Scanner;
	/****************************************************************
	Practice with a Binary Search Tree. Uses TreeNode.
    Prompt the user for an input string.  Build a Binary Search Tree 
	using Comparables.  Display it as a sideways tree (take the code 
	from the Tree Lab).  Prompt the user for a target and search the tree 
	for it.  Display the tree's minimum and maximum values.  Print 
	the data in order from smallest to largest.
	*****************************************************************/
public class Pd5GuoJonathanBinarySearchTree_SHELL
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner (System.in);
      System.out.print ("Enter a String: ");
      String s = sc.nextLine();
      
      TreeNode root = new TreeNode("" + s.charAt(0), null, null);
      for(int pos = 1; pos < s.length(); pos++)
      {
         insert(root, s.substring (pos, pos + 1));
      }
      
      display(root, 0);
   
      System.out.print("Enter a target: ");
      String target = sc.nextLine();
      
      if (find (root, target))
      {
         System.out.println("found: " + target);
      }
      else
      {
         System.out.println(target + " not found");
      }
      System.out.println("Min value = " + min(root));
      System.out.println("Max value = " + max(root));
      System.out.println();
      System.out.println("Small to Large: ");
      smallToLarge (root);
   }
      
   	/****************************************************************
   	Recursive algorithm to build a BST:  if the node is null, insert the 
   	new node.  Else, if the item is less, set the left node and recur to 
   	the left.  Else, if the item is greater, set the right node and recur 
   	to the right.   
   	*****************************************************************/
   public static TreeNode insert(TreeNode t, String s)
   {
   
      if(t == null)
      {
         return new TreeNode (s, null, null);
      }
      
      String node = "" + t.getValue();  	
      
      if (s.compareTo(node) <= 0)
      {
         t.setLeft(insert(t.getLeft(), s));
      }
      else if (s.compareTo(node) > 0)
      {
         t.setRight(insert(t.getRight(), s));
      }
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
   	
     /***************************************************************
      Iterative algorithm:  create a temporary pointer p at the root.  
   	While p is not null, if the p's value equals the target, return true.  
   	If the target is less than the p's value, go left, otherwise go right.   
   	If the target is not found, return false. 
      
   	Find the target. Recursive algorithm:  If the tree is empty, 
   	return false.  If the target is less than the current node 
   	value, return the left subtree.  If the target is greater, return 
   	the right subtree.  Otherwise, return true.   
   . ****************************************************************/    
   public static boolean find(TreeNode t, Comparable x)
   {
      TreeNode p = t;
      /*while (p != null)
      {
         String val = "" + p.getValue();
         if (x.compareTo (val == 0)
            return true;
         else if (x.compareTo (val) > 0)
            p.getLeft();
         else
            p.getRight();
      }
      return false;*/
      
      //Could not get to work iteratively
      
      if (p == null)
      {
         return false;
      }
      else
      {
         String val = "" + t.getValue();         
         if(x.compareTo (val) < 0)
         {
            return find(t.getLeft(), x);
         }
         if(x.compareTo(val) > 0)
         {
            return find(t.getRight(), x);
         }      
         return true;   
      }
   }
   
     /***************************************************************
   	starting at the root, return the min value in the BST.   
   	Use iteration.   Hint:  look at several BSTs. Where are 
   	the min values always located?  
   	***************************************************************/
   public static Object min(TreeNode t)
   {
      while (t.getLeft() != null)
      {
         t = t.getLeft();
      }
      return t.getValue();
   }
   /*****************************************************************
   	starting at the root, return the max value in the BST.  
   	Use recursion!
    *****************************************************************/
   public static Object max(TreeNode t)
   {
   
      if (t.getRight() == null)
      {
         return t.getValue();
      }
      return max (t.getRight());
   
   }
   public static void smallToLarge(TreeNode t)
   {
      if(t == null)
      {
         return;
      }
      else
      {
         smallToLarge(t.getLeft());
         System.out.print(t.getValue() + " ");
         smallToLarge(t.getRight());       
      } 
   }
}  //end of class

 /* TreeNode class for the AP Exams */

class TreeNode
{
   private Object value; 
   private TreeNode left, right;
   
   public TreeNode(Object initValue)
   { 
      value = initValue; 
      left = null; 
      right = null; 
   }
   
   public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight)
   { 
      value = initValue; 
      left = initLeft; 
      right = initRight; 
   }
   
   public Object getValue()
   { 
      return value; 
   }
   
   public TreeNode getLeft() 
   { 
      return left; 
   }
   
   public TreeNode getRight() 
   { 
      return right; 
   }
   
   public void setValue(Object theNewValue) 
   { 
      value = theNewValue; 
   }
   
   public void setLeft(TreeNode theNewLeft) 
   { 
      left = theNewLeft;
   }
   
   public void setRight(TreeNode theNewRight)
   { 
      right = theNewRight;
   }
}

/*
Outputs:

 
  ----jGRASP exec: java Pd5GuoJonathanBinarySearchTree_SHELL
 Enter a String: american
 		r
 			n
 	m
 			i
 		e
 			c
 a
 	a
 Enter a target: x
 x not found
 Min value = a
 Max value = r
 
 Small to Large: 
 a a c e i m n r 
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Pd5GuoJonathanBinarySearchTree_SHELL
 Enter a String: MAENIRAC
 		R
 	N
 M
 			I
 		E
 			C
 	A
 		A
 Enter a target: I
 found: I
 Min value = A
 Max value = R
 
 Small to Large: 
 A A C E I M N R 
  ----jGRASP: operation complete.
 

*/