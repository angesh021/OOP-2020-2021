package ie.tudublin;

public class Cat extends Animal
{
    private int numLives = 9; //can only be accessed within this class

    
    public Cat(String name)
    {
        super(name);
    }
    
    //public accessors set and get
    public void setNumLives(int lives)
    {
        this.numLives = lives;
    }
    public int getNumLives() 
    {
        return numLives;
    }

  
    //method for the kill
    public void kill()
    {
        if (numLives == 0)
        {
            System.out.println("Dead");
        }
        else
        {
            numLives --;
            System.out.println("Ouch!");
        }
    }
}