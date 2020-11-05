
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
    public static final int Max_modules = 4;
    //gives the course name and number as a class
    private String course;
    private String courseNumber;    
    private String codeNo;
    private String title;
    
    //this is the module marking, final mark and grade
    private int modulesAmount;
    private int finalCredit;
    private int finalMark;
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
        
        module1 = new Module("Programming Concepts", "CO452");
        module2 = new Module("Computer Architectures", "CO450");
        module3 = new Module("Web Development", "CO456");
        module4 = new Module("Digital Technologies", "CO454");
    }

    public void addMark(int mark, int moduleNo)
    {
        if(moduleNo == 1)
        {
            module1.awardMark(mark);
            module2.awardMark(mark);
            module3.awardMark(mark);
            module4.awardMark(mark);
        }
    }
    
    /**
     * Prints out the details of a course
     */
    public void print()
    {
        // put your code here
        System.out.println("Course " + codeNo + " - " + title);
    }
    
    public Grades convertToGrade(int mark)
    {
        if((mark >= 0) && (mark < 40))
        {
            return Grades.F;
        }
        
        else if((mark >= 40) && (mark < 50))
        {
            return Grades.D;
        }
        
        else if((mark >= 50) && (mark < 59))
        {
            return Grades.C;
        }
        
        else if((mark >= 60) && (mark < 69))
        {
            return Grades.B;
        }
        
        else if((mark >= 70) && (mark < 100))
        {
            return Grades.A;
        }
        
        return Grades.X;
    }
          
}
