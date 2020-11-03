/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Student Name
 */
public class TicketMachine
{
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    
    
    private Ticket aylesburyTicket;
    
    private Ticket amershamTicket;
    
    private Ticket highwycombeTicket;
    
    private Ticket selectedTicket;
    
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        
        balance = 0;
        total = 0;
        selectedTicket = null;
        createTickets();
    }

    public void selectamershamTicket()
    {
        selectedTicket = amershamTicket;
    }
    
    public void selecthighwycombeTicket()
    {
        selectedTicket = highwycombeTicket;
    }
    
    public void selectalesburyTicket()
    {
        selectedTicket = aylesburyTicket;
    }
    
    /**
     * Tickets created for destinations including prices
     */
    private void createTickets()
    {
        aylesburyTicket = new Ticket ("aylesbury",220);
        amershamTicket = new Ticket ("amersham",300);
        highwycombeTicket = new Ticket ("highwycombe",330);
    }
     
    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }
    
    public void insert20p()
    {
        balance = balance + 20;
        System.out.println("You have insterted 20p");
        printBalance();
    }
    
    public void insert10p()
    {
        balance = balance + 10;
        System.out.println("You have insterted 10p");
        printBalance();
    }
    
    public void insert100p()
    {
        balance = balance + 100;
        System.out.println("You have insterted 100p");
        printBalance();
    }
    
    public void insert200p()
    {
        balance = balance + 200;
        System.out.println("You have insterted 200p");
        printBalance();
    }
    
    
    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        int price = selectedTicket.getPrice();
        if(balance >= price) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            selectedTicket.print();
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
        
    }
    
    public void printBalance()
    {
        System.out.println("current balance = " + balance);
    }
}
