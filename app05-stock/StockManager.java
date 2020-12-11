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
    
    public void removeProduct(int id)
    {
        stock.remove(findProduct(id));
    }
    
    public void renameProduct(int id, String name)
    {
        findProduct(id).setName(name);
    }
    
    public void showDetails(int id)
    {
        Product product = findProduct(id);
        
        if(product != null)
        {
            System.out.println(product.toString());
        }
    }
    
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);
        
        if(product != null)
        {
            product.deliver(amount);
        }
        else
        {
            System.out.println("\nCannot find product with " + id + " id\n");
        }
    }
    
    public void sellProduct(int id, int quantity)
    {
        Product product = findProduct(id);
        
        if(product != null)
        {
            product.sell(quantity);
        }
    }
    
    public void reStock(int lowStock,int amount)
    {
        for(Product product : stock)
        {
            if(product.getQuantity() <= lowStock)
            {
                product.addQuantity(amount);
                System.out.println("\nRe-Stocked " + product.getName()
                + ". Final quantity in stock: " + product.getQuantity());
            }
        }
    }
    
    public Product findProduct(int id)
    {
        for(Product product : stock)
        {
            if(product.getID() == id) return product;
        }
        return null;
    }
    
    public boolean isDuplicate(int id)
    {
        Product product = findProduct(id);
        
        if(product == null)
            return false;
        else
            return true;
    }
    
    public boolean blankName(String name)
    {
        if(name.isEmpty()) return true;
        else return false;
    }
    
    public int numberOfProducts()
    {
        return stock.size();
    }
    
    public void printAllProducts()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }
    }
    
    public void printProductsWithName(String partOfProductName)
    {
        System.out.println("\nPrinting searched products:");
        System.out.println("\nSearch word: " + partOfProductName + "\n");
        boolean printedAtleastOneName = false;
        for(Product product : stock)
        {
            if(product.getName().toLowerCase().contains(partOfProductName))
            {
                System.out.println("Product = " + product);
                printedAtleastOneName = true;
            }        
        }
        if (printedAtleastOneName == false)
            System.out.println("No products match the search\n");
    }
    
    public void printLowStock(int amount)
    {
        System.out.println("\nPrinting low stock products:\n");
        boolean printedAtleastOneName = false;
        
        for(Product product : stock)
        {
            if(product.getQuantity() <= amount)
            {
                System.out.println(product);
                printedAtleastOneName = true;
                product.addQuantity(amount);
            }
        }
        if (!printedAtleastOneName)
            System.out.println("\nNo Products with low stock level\n");
    }
    
    public void printHeading()
    {
        System.out.println("\nPrinting Brian's Stock list");
        System.out.println("\n=====================\n");
    }
}
