/***********************************************************************************************************************************************
 * Name: Jonathan Guo
 * Period: 5
 * Name of the Lab: DLL Lab
 * Purpose of the Program: Learn more about doubly linked list and how to write methods pertaining to doubly linked list
  * Due Date: 9/29/19
 * Date Submitted: 9/29/19
 * What I learned: 
 * 1. I learned how to use the getPrev() and setPrev() methods and use this additional pointer to help write methods instead of needing to fully loop around the list
 * 2. I learned how I can use the two pointers to create a circular linked list
 * ... 
 * How I feel about this lab: I feel that this lab was relatively easy and that doubly linked list methods are much easier to write because there is more than one pointer
 * What I wonder: I wonder how much extra memory the second pointer takes up. If it is not too much why don't we just always use doubly linked lists?
 * Student(s) who helped me (to what extent):  None
 * Student(s) whom I helped (to what extent):  None
 *************************************************************************************************************************************************/
public class Pd5GuoJonathanDLL <E>
{
   // private static nested class
   private class DLNode <E>
   {
      private E value;
      private DLNode prev;
      private DLNode next;
      public DLNode(E arg, DLNode <E> p, DLNode <E> n)
      {
         value=arg;
         prev=p;
         next=n;
      }
      public DLNode()
      {
         value=null;
         next=this;
         prev=this;
      }
      public void setValue(E arg)
      {
         value=arg;
      }
      public void setNext(DLNode <E> arg)
      {
         next=arg;
      }
      public void setPrev(DLNode <E> arg)
      {
         prev=arg;
      }
      public DLNode <E> getNext()
      {
         return next;
      }
      public DLNode <E> getPrev()
      {
         return prev;
      }
      public E getValue()
      {
         return value;
      }
   }  // end of DLNode
   
   //*********************************************************************************************  Pd5GuoJonathanDLL class

   private int size;
   private DLNode <E> head = new DLNode <E> (); //dummy node--very useful--simplifies the code
   
   public int size()
   {   
      return size;
   }
   /* appends obj to end of list; increases size;
     @return true  */
   public boolean add(E obj)
   {
      DLNode<E> temp = head;
      while (temp.getNext() != head)
      {
         temp = temp.getNext();
      }
      temp.setNext (new DLNode (obj, temp, head));
      size++;
      return true;
   }
   /* inserts obj at position index.  increments size. 
   	*/
   public void add(int index, E obj)
   {
      DLNode<E> temp = head;
      int count = 0;
      while (count + 1 != index)
      {
         temp = temp.getNext();
         count++;
      }
      size++;
      temp.setNext (new DLNode (obj, temp, temp.getNext()));
   }
   /* return obj at position index.  
   	*/
   public E get(int index)
   {
      DLNode<E> temp = head;
      int count = 0;
      while (count != index)
      {
         temp = head.getNext();
         count++;
      }
      return temp.getValue();
   }
   /* replaces obj at position index.  
   	*/
   public void set(int index, E obj)
   {
      DLNode <E> temp = head;
      for (int i = 0; i < index; i++)
      {
         temp = temp.getNext();
      }
      temp.setValue(obj);
   }
   /*  removes the node from position index.  decrements size.
     @return the object at position index.
    */
   public E remove(int index)
   {
      DLNode<E> temp = head.getNext();
      int count = 0;
      while (count != index)
      {
         temp = temp.getNext();
         count++;
      }
      temp.getPrev().setNext(temp.getNext());
      temp.getNext().setPrev(temp.getPrev());
      size--;
      return temp.getValue();
   }
   /* inserts obj at front of list; increases size;
     */
   public void addFirst(E obj)
   {
		DLNode<E> temp = new DLNode<E>(obj, null, head.getNext());
		head.setNext(temp);
		head.getNext().getNext().setPrev(temp);
		size++;
   }
   /* appends obj to end of list; increases size;
       */
   public void addLast(E obj)
   {
      DLNode<E> temp = head.getNext();
      while (temp.getNext() != head)
      {
         temp = temp.getNext();
      }
      temp.setNext (new DLNode (obj, temp, head));
      size++;
   }
      
   public E getFirst()
   {
      return head.getNext().getValue();
   }
   public E getLast()
   {
      return head.getPrev().getValue();
   }
   public E removeFirst()
   {
      DLNode <E> temp = new DLNode (head.getNext().getValue(), null, head);
      head = head.getNext();
      size--;
      return temp.getValue();
   }
   public E removeLast()
   {
      DLNode <E> temp = head.getPrev();
      temp.getPrev().setNext(null);
      size--;
      return temp.getValue();
   }
   public String toString()
   {
      String s = "";
      for (DLNode<E>temp = head.getNext(); temp != head.getPrev(); temp = temp.getNext())
      {
         s+= temp.getValue() + " ";
      }
      return s;
   }



   public static void main(String args[])
   {
      Pd5GuoJonathanDLL <String> list = new Pd5GuoJonathanDLL <String> ();	
   
      list.addLast("Apple");
      list.addLast("Banana");
      list.addLast("Cucumber");
      list.add("Dumpling");
      list.add("Escargot");
      System.out.println(list);
      System.out.println("Size: " + list.size());
      Object obj = list.remove(3);
      System.out.println(list);
      System.out.println("Size: " +list.size());
      System.out.println("Removed "+ obj);
      System.out.print("Add at 3:   ");
      list.add(3,"Cheese");
      System.out.println(list);
      System.out.println("Get values at 1 and first: " + list.get(1)+" and " + list.getFirst());
      System.out.println("No change: " +list);
      System.out.println( list.removeFirst() + " is now removed!"); 
      System.out.println(list);
      System.out.print("Add first:  ");
      list.addFirst("Anchovie");
      System.out.println(list);
      System.out.println("Size: " + list.size());
      System.out.print("Set the second:  ");
      list.set(2, "Bread");
      System.out.println(list);
   }
}

/* Outputs:
 
  ----jGRASP exec: java Pd5GuoJonathanDLL
 Apple Banana Cucumber Dumpling Escargot 
 Size: 5
 Apple Banana Cucumber Escargot 
 Size: 4
 Removed Dumpling
 Add at 3:   Apple Banana Cheese Cucumber Escargot 
 Get values at 1 and first: Apple and Apple
 No change: Apple Banana Cheese Cucumber Escargot 
 Apple is now removed!
 Banana Cheese Cucumber Escargot 
 Add first:  Anchovie Banana Cheese Cucumber Escargot 
 Size: 5
 Set the second:  Anchovie Bread Cheese Cucumber Escargot 
 
  ----jGRASP: operation complete.
 
*/
