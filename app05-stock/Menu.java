
/**
 * Write a description of class Menu here.
 *
 * @author (Brian Ruszkowski)
 * @version (05/12/2020)
 */
public class Menu
{
    private static InputReader reader = new InputReader();
    
    public static String getMenuChoice(String [] choices)
    {
        boolean finished = false;
        String choice = null;
        
        while(!finished)
        {
            printChoices(choices);            
           
            choice = reader.getInput();
            choice = choice.toLowerCase();
            
            finished = checkIsValid(choices, choice);      
            if(!finished)
            {
                System.out.println(" Not a valid choice!");
            }            
        }
        
        return choice;
    }
    
    private static boolean checkIsValid(String [] choices, String choice)
    {
        for(String validchoice : choices)
        {
            validchoice = validchoice.toLowerCase();
            
            if(validchoice.startsWith(choice))
                return true;
        }
        
        return false;
    }
    
    private static void printChoices(String [] choices)
    {
        System.out.println(" Enter the first word, your Choices are: \n");
        
        for(String choice: choices)
        {
            System.out.println(choice);
        }
    }
}
