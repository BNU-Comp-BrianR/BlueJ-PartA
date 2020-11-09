import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (Brian Ruszkowski) 
 * @version (08/11/2020)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProduct(id);
        if(product != null)
        {
           product.increaseQuantity(amount);
           System.out.println("Product Delivered : " + product);
        }
        else
        {
            System.out.println("Product ID "+ id + " NOT FOUND!!!");
        }
    }
    
        /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id, int quantity)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
           System.out.println( "Available stock :" + product.getQuantity());
           product.sellOne();
           System.out.println(product);
        }
        else
        {
            System.out.println( " Product not found");
        }
    }
    
        /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
        public Product findProduct(int id)
    {
          for(Product product : stock)
        {
            if(product.getID() == id)
            {
                return product;
            }
        }
        return null;        
    }  
        
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        if(product != null)
        {
            stock.remove(product);
            System.out.println("The product has been removed from Stock");
        }
    }
         
    public Product findByKeword(String productName)
    {
        for( Product product : stock)
        {
            if(product.getName().contains(productName))
            {
               return product;
            }
            else
            {
               System.out.println(" Product not Found!!! ");
            }
        }
        return null;
    }
                               
    public void changeProductName(int id, String replacement)
    {
        Product product = findProduct(id);
        if(product != null)
        {
            changeProductName( id, replacement);
        }
        else
        {
            System.out.println("Product not found on the database");
        }
    }
        
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    //change this.....................
    public void printAllProducts()
    {
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
}
