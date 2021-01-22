public class Freak extends AbstractWarrior
{
   public Freak (String name)
   {
      super (name, 'F');
   }
   
   public void generateStats ()
   {
      setIQ ((int)(Math.random() * 120 + 60)); 
      setStrength ((int)(Math.random() * 99 + 1));
   
   }
}