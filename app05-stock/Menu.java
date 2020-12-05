
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
            System.out.println(choices);
        }
    }
}
