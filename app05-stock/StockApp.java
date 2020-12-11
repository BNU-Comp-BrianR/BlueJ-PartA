
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Brian Ruszkowski
 * @version 0.1
 */
public class StockApp
{
    
    public final int FIRST_ID = 113;
    
    public final String ADD = "add";
    
    public static final String CLEAR_CODE = "\u000C";
    
    public static final char ESC_CODE = 0x1B;
    
    public static final String ENTER_ID = "Enter a product ID";
    
    public static final String ENTER_NAME = "Enter the product name";
    
    public static final String TYPE_CHOICE = "Type your choice";
    // Use to get user input
    private InputReader input;
    
    private StockManager manager;
    
    private StockDemo demo;
    
    private int nextID = FIRST_ID;
    
    private int lowStockAmount = 2;
    
    private String [] menuChoices;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        input = new InputReader();
        manager = new StockManager();
        demo = new StockDemo(manager);
        
        setUpMenu();
    }
    
    private void setUpMenu()
    {
        menuChoices = new String []
        {
          "Add a new product",
          "Remove an old product",
          "Deliver a quanitiy of product",
          "Sell a quantity of products",
          "Restock on stock",
          "Search for a product",
          "Print all products",
          "Quit the program"
        };
    }

    /**
     * 
     */
    public void run()
    {
        System.out.println(CLEAR_CODE);
        
        boolean finished = false;        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
            
            String choice = input.getString(TYPE_CHOICE);
            choice = choice.toUpperCase();
            
            if(choice.startsWith("QUIT"))
            {    
                finished = true;
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
    }
        
    /**
     * 
     */
    public void executeMenuChoice(String choice)
    {
        if(choice.equals("ADD"))
        {
            addProduct();
        }
        else if(choice.equals("REMOVE"))
        {
            removeProduct();
        }
        else if(choice.equals("PRINT"))
        {
            printAllProducts();
        }
        else if(choice.equals("DELIVER"))
        {
            deliverProduct();
        }
        else if(choice.equals("SELL"))
        {
            sellProduct();
        }
        else if(choice.equals("PRINTLOW"))
        {
            printLowStock();
        }
        else if(choice.equals("SEARCH"))
        {
            searchForProduct();
        }
        else if(choice.equals("RESTOCK"))
        {
            restockProducts();
        }
        else
        {
            System.out.println("Invalid choice! Please choose from the menu");
        }
    }
    
    public void addProduct()
    {
        System.out.println("Add a new Product");
        
        String name = input.getString(ENTER_NAME);
        
        int id = input.getInt(ENTER_ID);
        
        if(manager.isDuplicate(id) || manager.blankName(name))
        {
            System.out.println("Duplicate id or blank name, item not added!");
        }
        else
        {
            Product product = new Product(id, name);
            
            manager.addProduct(product);
            
            System.out.println("\nNew Product added " + product + "\n");
        }
    }        
        
    public void removeProduct()
    {
        System.out.println("Remove a Product");
        
        int id = input.getInt(ENTER_ID);
        
        if(manager.isDuplicate(id))
        {
            Product product = manager.findProduct(id);
            System.out.println("\n" + product.getName() + " removed\n");
            manager.removeProduct(id);
        }
        else
        {
            System.out.println("No product with that ID!");
        }       
    }
    
    private void deliverProduct()
    {
        System.out.println("\nWaiting for product delivery");
        
        int id = input.getInt(ENTER_ID);
        
        int amount = input.getInt("Enter delivery amount");
        
        manager.deliverProduct(id, amount);
    }
    
    private void sellProduct()
    {
        System.out.println("\nSelling a product");
        
        int id = input.getInt(ENTER_ID);
        
        int amount = input.getInt("How many items to sell?");
        
        manager.sellProduct(id, amount);
    }
    
    private void searchForProduct()
    {
        System.out.println("\nSearch for a product");
        
        String name = input.getString("Enter part of a product's name");
        name = name.toLowerCase();
        
        manager.printProductsWithName(name);
    }
    
    private void restockProducts()
    {
        System.out.println("\nPrinting low stock products");
        
        int amount = input.getInt("Enter amount to re-stock");
        
        manager.printLowStock(amount);
    }
    
    private void printLowStock()
    {
        System.out.println("\nPrinting low stock products");
        
        lowStockAmount = input.getInt("Enter amount for low stock");
        
        manager.printLowStock(lowStockAmount);
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Deliver:    Deliver a quantity of product");
        System.out.println("    Sell:       Sell a quantity of products");
        System.out.println("    Restock:    Restock on stock"); 
        System.out.println("    Search:     Search for a product");
        System.out.println("    Print:      Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    public void printAllProducts()
    {
        manager.printAllProducts();
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Brian Ruszkowski");
        System.out.println("******************************");
    }
}
