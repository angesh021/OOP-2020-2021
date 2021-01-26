package ie.tudublin;

public class Cat extends Animal
{
    private int numLives = 9; //can only be accessed within this class

    
    public Cat(String name)
    {
        super(name);
    }
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
        if (numLives > 0)
        {
            numLives --;
            System.out.println("Ouch!");
        }
        else
        {
            System.out.println("Dead");
        }
    }
}