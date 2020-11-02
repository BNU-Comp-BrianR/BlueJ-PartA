import java.util.Date;

/**
 * Write a description of class Ticket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ticket
{
    // instance variables - replace the example below with your own
    private String destination;
    
    private int price;
    
    private Date issueDate;

    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(String destination, int price)
    {
        this.destination = destination;
        this.price = price;
        this.issueDate = new Date();
    }

    public int getPrice()
    {
        return price; 
    }
    
    public void print()
    {
        System.out.println("Ticket: " + destination + " Price " + price + " " + issueDate);
    }
}
