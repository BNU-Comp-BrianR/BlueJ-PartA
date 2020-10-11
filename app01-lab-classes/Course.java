
/**
 * Write a description of class Course here.
 *
 * @author (Brian Ruszkowski)
 * @version (Version 0.1)
 */
public class Course
{
    // Attributes
    private String title;
    
    private String codeNo;
    
    // Methods

    /**
     * Constructor for objects of class Course
     */
    public Course(String title, String codeNo)
    {
        this.title = title;
        this.codeNo = codeNo;
    }

    public void print()
    {
        System.out.println("course: " + title + ", Code No: " + codeNo);
    }
    
}
