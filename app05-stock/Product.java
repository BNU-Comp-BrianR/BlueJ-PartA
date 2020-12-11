  
/**
 * Model some details of a product sold by a company.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class Product
{
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * @return The product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return The product's name.
     */
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return The quantity in stock.
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    public void addQuantity(int amount)
    {
        quantity+= amount;
    }

    /**
     * @return The id, name and quantity in stock.
     */
    public String toString()
    {
        return id + ": " +  name + " stock level: " + quantity;
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void deliver(int amount)
    {
        if(amount > 0) 
        {
            quantity += amount;
            System.out.println("\nDelivered " + amount + " of " + name
                + ". Final quanity in stock: " + quantity);
        }
        else 
        {
            System.out.println("Attempt to restock " + name +
                               " with a non-positive amount: " + amount);
        }
    }

    /**
     * Sell one of these products.
     * An error is reported if there appears to be no stock.
     */
    public void sell(int quantityOrdered)
    {
        if(quantity >= quantityOrdered && quantityOrdered > 0)
        {
            System.out.println("\nselling " + quantityOrdered + " of " + name);
            quantity-= quantityOrdered;
            System.out.println("\nSold " + quantityOrdered + " of " + name
                + ". Fianl quantity in stock: " + quantity);
        }
        else if(quantity < quantityOrdered && quantityOrdered > 0)
        {
            System.out.println("\nFailed to sell " + quantityOrdered + " of " + name);
            System.out.println("\nSelling " + quantity + " of " + name);
            quantityOrdered -= quantity;
            quantity = 0;
            System.out.println("\nLacking " + quantityOrdered + " copies of " + name);
        }
        else
        {
            System.out.println("\nFailed to sell " + quantityOrdered + " of " + name);
            System.out.println("\nNegative amount or 0!");           
        }
    }
}

