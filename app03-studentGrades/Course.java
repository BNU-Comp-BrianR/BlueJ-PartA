
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Derek Peacock
 * @version 0.1 11/Sep/2020
 */
public class Course
{
    //this will make sure the maximum modules are 4
    public static final int MAX_MODULES = 4;
    //gives the course name and number as a class    
    private String codeNo;
    private String title;
    
    //this is the module marking, final mark and grade
    private int noModules;
    private int totalCredit;
    private int totalMark;
    private int meanMark;  
    
    private Grades finalGrade;
        
    //to see if the course is completed
    private boolean complete;
    //4 modules
    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;
    
       
    /**
     * Constructor for objects of class Course
     */
    public Course(String codeNo, String title)
    {
        // initialise instance variables
        this.codeNo = codeNo;
        this.title = title;
        //resets the numbers to zero
        noModules = 0;
        totalMark = 0;
        totalCredit = 0;
        complete = false; 
        
        createModules();
    }
    
    public void createModules()
    {
        module1 = new Module("Programming Concepts", "CO452");
        module2 = new Module("Digital Technologies", "CO454");
        module3 = new Module("Web Development", "CO456");
        module4 = new Module("Computer Architctures", "CO452");
        
        noModules = 4;
    }
    
    public void addModule(int moduleNo, Module module)
    {
        if((moduleNo >= 1) && (moduleNo <= MAX_MODULES)) noModules++;
        
        switch (moduleNo)
        {
            case 1: module1 = module; break;
            case 2: module2 = module; break;
            case 3: module3 = module; break;
            case 4: module4 = module; break;
        }
    }
    
    public void awardMark(int moduleNo, int mark)
    {
        switch(moduleNo)
        {
            case 1: module1.awardMark(mark); break;
            case 2: module2.awardMark(mark); break;
            case 3: module3.awardMark(mark); break;
            case 4: module4.awardMark(mark); break;
        }
    }
    
    /**
     * Prints out the details of a course
     */
    public void print()
    {
        // put your code here
        System.out.println("Course " + codeNo + " - " + title);
        System.out.println();
        
        printModules();
    }
    
    private void printModules()
    {
        if(module1 != null) module1.print();
        if(module2 != null) module2.print();
        if(module3 != null) module3.print();
        if(module4 != null) module4.print();       
    }
    
    public void printGrade()
    {
        if(noModules == MAX_MODULES)
        {
            totalMark = 0;
            
            addMark(module1);
            addMark(module2);
            addMark(module3);
            addMark(module4);
            
            meanMark = totalMark / MAX_MODULES;
            
            if(totalCredit == 60)
            {
                System.out.println("Your final mark is " + meanMark + 
                                   " your final grade is " + calculatedGrade());
            }
            else
            {
                System.out.println("You have not completed the course yet!");
            }
            
        }
    }
    
    private void addMark(Module module)
    {
        if(module.isComplete())
        {
            totalMark = totalMark + module.getMark();
            totalCredit += module.getCredit();
        }
    }
            
    
    private String calculatedGrade()
    {                          
        
        if(meanMark <= 40)
        {
            return "F";
        }
        else if(meanMark <= 50)
        {
            return "D";
        }
        else if(meanMark <= 60)
        {
            return "C";
        }
        else if(meanMark <= 70)
        {
           return "B";
        }
        else return "A";
    }
    
                                                      
}
