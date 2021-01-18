
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private final String name;
    private int experience;
    
    private int score;
    private int count;
    private int health;

    /**
     * the name of the player and the amount of points he starts with
     */
    public Player(String name)
    {
        this.name = name;
        score = 0;
        health = 100;
    }
    
    /**
     * Class to get score
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Class to set score
     */
    public void setScore(int score)
    {
        this.score = score;
    }
    
    /**
     * Class for reseting score if player dies or wants to reset score 
     */
    public void resetScore()
    {
        score = 0;
    }
        
    /**
     * Class for increasing the amount of points you have
     */
    public void increaseScore(int amount)
    {
        if(amount > 0)
            score += amount;
    }
    
    /**
     * Class to be able to see what score you have
     */
    public void setCount(int count)
    {
        this.count = count;
    }
    
    /**
     * Class to set player's health
     */
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    /**
     * Class to get health for the player
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * Class to set player's experience
     */
    public void setExperience(int experience)
    {
        this.experience = experience;
    }
    
    /**
     * Class to get experience
     */
    public int getExperience()
    {
        return experience;
    }
    
    /**
     * Class for printing player's name
     */    
    public void print()
    {
        System.out.println("Player : " + name);
        System.out.println();
    }
    
}
