/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    public static final int FIRST_ID = 101;
    public static final int LAST_ID = 112;
    
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        
        int id = FIRST_ID;
        
        manager.addProduct(new Product(id, "Samsung Galaxy S20"));
        id++;
        manager.addProduct(new Product(id, "Apple iPhone 12"));
        manager.addProduct(new Product(103, "Google Pixel 4A"));
        manager.addProduct(new Product(104, "Samsung Galaxy S20"));
        manager.addProduct(new Product(105, "Apple iPhone 12"));
        manager.addProduct(new Product(106, "Google Pixel 4A"));
        manager.addProduct(new Product(107, "Samsung Galaxy S20"));
        manager.addProduct(new Product(108, "Apple iPhone 12"));
        manager.addProduct(new Product(109, "Google Pixel 4A"));
        manager.addProduct(new Product(110, "Samsung Galaxy S20"));
        manager.addProduct(new Product(111, "Apple iPhone 12"));
        manager.addProduct(new Product(112, "Google Pixel 4A"));
        
    }
    
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        
        if(product == null)
        {
            System.out.println("Product with ID: " + id + " is not recognised.");
        }
        return product;
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void runDemo()
    {
        manager.printAllProducts();
        
        demoDelivery();
        manager.printAllProducts();
    }
    
    private void demoDelivery()
    {
        int amount = 0;
        for(int id = 101; id <= 112; id++)
        {
            manager.deliverProduct(id, amount);
            amount++;
        }
        
    }
    
}
