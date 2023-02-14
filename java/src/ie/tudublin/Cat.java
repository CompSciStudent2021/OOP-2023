package ie.tudublin;

public class Cat
{
	String name;

    private int numLives = 9;
	
	public void setName(String name)
	{
		this.name = name;
	}

    public int getNumLives()
    {
        return numLives;
    }
	
	public Cat()
	{
	}
	
	public Cat(String name)
	{
	}

    public void kill()
    {
        numLives--;
        
        if (numLives > 0)
        {
            System.out.println("Ouch");
        }
        else
        {
            System.out.println("Dead");
        }
    }
	
	public void speak()
	{
		System.out.println("Meow");
	}
}