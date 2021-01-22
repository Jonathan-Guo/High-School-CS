public class ExtraChargeOrder extends Order
{
   public ExtraChargeOrder (String name, int number, int quantity, double price)
   {
      super(name, number, quantity, price);
   }
   
   public double computePrice ()
   {
      return super.computePrice() + 4.0;
   }
   
   public static void main (String [] args)
   {
      Order smallOrder = new Order ("Tom", 123, 20, 12.99);
      Order secondOrder = new Order ("Tom", 123, 20, 12.99);
      ExtraChargeOrder largeOrder = new ExtraChargeOrder ("John", 456, 1000, 25.99);
      
      System.out.println (smallOrder.computePrice());
      System.out.println (largeOrder.computePrice());
      
      System.out.println (smallOrder);
      System.out.println (largeOrder);
      
      System.out.println (smallOrder == secondOrder);
      System.out.println (smallOrder.equals (secondOrder));
   }
}