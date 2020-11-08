
/**
 * Write a description of class Module here.
 *
 * @author (Brian Ruszkowski)
 * @version (03/11/2020)
 */
public class Module
{
    private String title;
    
    private String codeNo;
    
    private int mark;
    
    private boolean completed;
    
    private int credit;
    

    /**
     * Constructor for objects of class Module
     */
    public Module(String title, String codeNo)
    {
        mark = 0;
        credit = 0;
        
        this.title = title;
        this.codeNo = codeNo;
        completed = false;
    }
    
    public void awardMark(int mark)
    {
        if((mark >= 0) && (mark <= 100))
        {
            this.mark = mark;
            if(mark >= 40)
            {
                completed = true;
                credit = 15;
            }
        }
        else
        {
            System.out.print("Invalid mark!!!");
        }
    }
    
    public int getCredit()
    {
        return credit;
    }
    
    public void print()
    {
        System.out.println("Module: " + codeNo +
        " " + title + " mark ");
    }
    
    public String getTitle()
    {
        return this.title;
    }//end method GetTitle
                
    public String getCodeNo()
    {
        return this.codeNo;
    }//end method getCodeNo
    
    public int getMark()
    {
        return this.mark;
    }//end method getMark
        
    public boolean isComplete()
    {
        return this.completed;
    }//end method getCompleted    
        
    
}
