public abstract class AbstractWarrior
{
   private int IQ, strength;
   private String name;
   private char clique;
   private boolean alive = true;
   
   public AbstractWarrior (String name, char clique)
   {
      this.name = name;
      this.clique = clique;
   }
   
   public abstract void generateStats ();
   
   public int getIQ ()
   {
      return IQ;
   }
   
   public void setIQ (int newIQ)
   {
      IQ = newIQ;
   }
   
   public int getClique ()
   {
      return clique;
   }
   
   public void setClique (char newClique)
   {
      clique = newClique;
   }
   
   public String getName ()
   {
      return name;
   }  
   
   public void setName (String newName)
   {
      name = newName;
   }
      
   public int getStrength ()
   {
      return strength;
   }
   
   public void setStrength (int newStrength)
   {
      strength = newStrength;
   }
   
   public boolean isAlive ()
   {
      return alive;
   }
   
   public void setAlive (boolean newAlive)
   {
      alive = newAlive;
   }
   
   public String toString ()
   {
      return "Name: " + name + "\nIQ: " + IQ + "\nStrength: " + strength + "\nClique: " + clique + "\n";
   }
   
   public AbstractWarrior fight (AbstractWarrior other)
   {
      if (this.getIQ() > other.getIQ() + 20)
      {
         other.alive = false;
         System.out.println("\n" + this.name + " beats " + other.name + " by IQ!");
         return this;
      }
      else if (other.getIQ() > this.getIQ() + 20)
      {
         this.alive = false;
         System.out.println("\n" + other.name + " beats " + this.name + " by IQ!");
         return other;
      }
      else if (this.getStrength() > other.getStrength())
      {
         other.alive = false;
         System.out.println("\n" + this.name + " beats " + other.name + " by strength!");
         return this;
      }
      else 
      {
         this.alive = false;
         System.out.println("\n" + other.name +  " beats " + this.name + " by strength!");
         return other;
      }
   }
}

