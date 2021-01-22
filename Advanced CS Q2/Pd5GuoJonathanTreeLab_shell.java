/**
* Name: Jonathan Guo                  
* Period: 5
* 
* Purpose of the Program: Learn how to access and analyze a tree using tree methods
* Date Submitted: 1/14/20
* 
* What I learned: 
*  - For preorder, inorder, and post order: when to use the print statement so that it prints the correct order for each method 
   - To do the height, it must be subtracted by one at the end since the height is the total number of nodes - 1
   - I learned the logic to count single child nodes by comparing both nodes afterwards to see if one was null and the other not
   
* How I feel about this lab: 
   I feel pretty good about my knowledge of trees and how to implement methos from the tree class to access information from trees
* 	
* What I wonder: 
   I wonder in what scenarios we would use trees other than another type of list like a linked list or arraylist.
   I also wonder why binary tree is such an important type of tree when nary trees can store more information
   
* Credits:
- https://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/
- Helped me write the method for the min and max. It showed me the logic on how to compare the values recursively as well as 
  making sure that my null case would not return a value that could be affect the program.
  
* Students whom I helped (to what extent): None
*/
import java.util.*;                     //for the queue interface
public class Pd5GuoJonathanTreeLab_shell       
{
   public static void main(String[] args)
   {
      String s = "XCOMPUTERSCIENCE";
   		
      TreeNode root = new TreeNode("" + s.charAt(1), null, null);
         
       // The root node has index 1
       // The second level nodes' indices: 2, 3
       // The third level nodes' indices: 4,5,6,7
       // Idea: based on the index of the node, log (pos) of base 2 calculates the level of the
       //          node: root (index 1) on level 1. Node with index 2 or 3 is on level 2
      for(int pos = 2; pos < s.length(); pos++)
         insert(root, "" + s.charAt(pos), pos, (int)(1 + Math.log(pos) / Math.log(2)));
      
      // NOTE: The following 3 lines are supposed to further show you how insert works. You
      //             uncomment them and see how the tree looks like with these 3 additional nodes
      insert(root, "A", 17, 5); 
      insert(root, "B", 18, 5); 
      insert(root, "C", 37, 6); //B's right child
      
      // display the tree sideway; see the sample output at the end of this file
      display(root, 0);
      
      System.out.print("\nPreorder: ");
      preorderTraverse(root);
      System.out.print("\nInorder: ");
      inorderTraverse(root);
      System.out.print("\nPostorder: ");
      postorderTraverse(root);
      
      System.out.println("\n\nNodes = " + countNodes(root));
      System.out.println("Leaves = " + countLeaves(root));
      System.out.println("Grandparents = " + countGrandParentNodes(root));  // count the number grandparent nodes
      System.out.println("Only childs = " + countSingleChildNodes(root));	   // count the number of nodes that has only 1 child
         
      //System.out.println("\nDepth = " + numOfLevels(root));                    
      System.out.println("Height = " + height(root));
   
      System.out.println("Min = " + min(root));
      System.out.println("Max = " + max(root));	
      
      System.out.println("\nBy Level: ");
      displayLevelOrder(root);     // level by level display of the nodes (starts from left to right for nodes on the same level)
      
   } // end of main
   
   
   // insert a new node in the tree based on the node's level
   public static void insert(TreeNode t, String s, int pos, int level)
   {
      TreeNode p = t;
      for(int k = level - 2; k > 0; k--)
         //  then 1 << 4 will insert four 0-bits at the right of 1 (binary representation of 1 is 1. 
         // 1 << 4 results in 10000 (in binary)
         if((pos & (1 << k)) == 0) 
            p = p.getLeft();      // What does this do? Answer this question first.  What does '&' do? Google it!!!!
         else                     //  We did not learn this in AP CS A!  :
            p = p.getRight();    // What does this do? Answer this question first.
            
      if((pos & 1) == 0)
         p.setLeft(new TreeNode(s, null, null));
      else
         p.setRight(new TreeNode(s, null, null));
   } // end of insert
      
      
   /*****************************************************************************************************   
     postcondition: display the tree sideway   
   *****************************************************************************************************/   
   public static void display(TreeNode t, int level)
   {
      if(t == null)
         return;
      display(t.getRight(), level + 1); //recurse right
         
      for(int k = 0; k < level; k++)
         System.out.print("\t");
      System.out.println(t.getValue());
         
      display(t.getLeft(), level + 1); //recurse left
   }  // end of display
        
   public static void preorderTraverse(TreeNode t)
   {
      if(t == null)
      {
         return; 
      }
      System.out.print(t.getValue() + " ");
      preorderTraverse(t.getLeft());
      preorderTraverse(t.getRight());
   }
    
   public static void inorderTraverse(TreeNode t)
   {
      if(t == null)
      {
         return;
      }
      inorderTraverse(t.getLeft());
      System.out.print(t.getValue() + " ");
      inorderTraverse(t.getRight());   
   }
   
   
   public static void postorderTraverse(TreeNode t)
   {
      if(t == null)
      {
         return;
      }         
      postorderTraverse(t.getLeft());
      postorderTraverse(t.getRight());
      System.out.print(t.getValue() + " ");         
   }
   
   public static int countNodes(TreeNode t)
   {
      int num = 0;
      if(t == null)
      {
         return 0;
      }
      else
      {
         return 1 + countNodes(t.getRight()) + countNodes(t.getLeft());
      }
   }
     
   public static int countLeaves(TreeNode t)
   {
      if(t.getLeft() == null && t.getRight() == null)
      {
         return 1;
      }
      else if (t.getLeft() == null)
      {
         return countLeaves(t.getRight());
      } 
      else if (t.getRight() == null)
      {
         return countLeaves(t.getLeft());
      }
      else 
      {
         return countLeaves(t.getLeft()) + countLeaves(t.getRight());
      }
   }
   
   public static int countGrandParentNodes(TreeNode t)
   {
      if (t != null)
      {
         if (height(t) >= 2)
         {
            return 1 + countGrandParentNodes(t.getLeft()) + countGrandParentNodes(t.getRight());
         }
      }
      return 0;
   }
   
   
   public static int countSingleChildNodes(TreeNode t)
   {
      if(t.getRight() == null && t.getLeft() == null)
      {
         return 0;
      }
      else if(t.getRight() != null && t.getLeft() == null)
      {
         return 1 + countSingleChildNodes(t.getRight());
      }
      else if(t.getRight() == null && t.getLeft() != null)
      {
         return 1 + countSingleChildNodes(t.getLeft());
      }
      else 
      {
         return 0 + countSingleChildNodes(t.getRight()) + countSingleChildNodes(t.getLeft());
      }
   }
      
   public static int height(TreeNode t)
   {
      if (t == null) 
         return -1; 
      else 
      { 
         int left = height(t.getLeft()); 
         int right = height(t.getRight()); 
      
         if (left > right) 
         {
            return (left + 1); 
         }
         else 
         {
            return (right + 1); 
         }
      }
   }
 
   public static Object min(TreeNode t)
   {
      if(t == null) 
      {
         return "no min";
      }
      else 
      {
         String result = "" + t.getValue();
         String left = "" + (min(t.getLeft()));
         String right = "" + (min(t.getRight()));
         if(left.compareTo(result) < 0) 
         {
            result = left;
         }
         if(right.compareTo(result) < 0) 
         {
            result = right;
         }
         return result;
      }
   }
      
   public static Object max(TreeNode t)
   {
      if(t == null) 
      {
         return Integer.MIN_VALUE;
      }
      else 
      {
         String result = "" + t.getValue();
         String left = "" + (max(t.getLeft()));
         String right = "" + (max(t.getRight()));
         if(left.compareTo(result) > 0) 
         {
            result = left;
         }
         if(right.compareTo(result) > 0) 
         {
            result = right;
         }
         return result;
      }
   }
   
   /*****************************************************************************************************
        This method is not recursive.  
        Hint: Use a local queue to store the children of the current node.
   *****************************************************************************************************/
   public static void displayLevelOrder(TreeNode t)
   {
      Queue<TreeNode> q = new LinkedList <TreeNode>(); 
      TreeNode current = t;
      q.add(current); 
   
      while(!q.isEmpty())
      {
         current = q.remove();
         System.out.print(current.getValue());
      
         if (current.getLeft() != null)
         {
            q.add(current.getLeft());
         }
         if (current.getRight() != null)
         {
            q.add(current.getRight());
         }
      }      
   }
}  // end of TreeLab_shell



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


   /***************************************************
	  
      ----jGRASP exec: java Lab01
    
    			E
    		E
    			C
    	M
    			N
    		T
    			E
    C
    			I
    		U
    			C
    	O
    			S
    					C
    				B
    		P
    				A
    			R
    
    Preorder: C O P R A S B C U C I M T E N E C E 
    Inorder: R A P B C S O C U I C E T N M C E E 
    Postorder: A R C B S P C I U O E N T C E E M C 
    
    Nodes = 18
    Leaves = 8
    Grandparents = 5
    Only childs = 3
    
    Depth =5
    Height = 4
    Min = A
    Max = U
    
    By Level: 
    COMPUTERSCIENCEABC
   
    *******************************************************/
	  
/*
Outputs:
 
  ----jGRASP exec: java Pd5GuoJonathanTreeLab_shell
 			E
 		E
 			C
 	M
 			N
 		T
 			E
 C
 			I
 		U
 			C
 	O
 			S
 					C
 				B
 		P
 				A
 			R
 
 Preorder: C O P R A S B C U C I M T E N E C E 
 Inorder: R A P B C S O C U I C E T N M C E E 
 Postorder: A R C B S P C I U O E N T C E E M C 
 
 Nodes = 18
 Leaves = 8
 Grandparents = 5
 Only childs = 3
 Height = 5
 Min = A
 Max = U
 
 By Level: 
 COMPUTERSCIENCEABC
  ----jGRASP: operation complete.
 



*/