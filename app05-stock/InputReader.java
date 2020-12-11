import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned.
 * 
 * @author     Brian Ruszkowski
 * @version    (05/12/2020)
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     */
    public String getString(String prompt)
    {
        boolean isValid = false;
        String inputLine = null;
        
        while(isValid == false)
        {
            System.out.println(prompt + " > ");         // print prompt
            inputLine = reader.nextLine();
            if(inputLine.isBlank())
            {
                System.out.println("Your imput is blank");
            }
            else isValid = true;
        }
        
        return inputLine;
    }
    
    public int getInt(String prompt)
    {
        System.out.println(prompt + " > ");         // print prompt
        int number = reader.nextInt();

        return number;
    }
}
