
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private final String name;
    private int score;
    private int count;
    

    public Player(String name)
    {
        this.name = name;
        score = 0;
    }
    
    public void print()
    {
        System.out.println("Player : " + name);
        System.out.println();
    }
    
}
