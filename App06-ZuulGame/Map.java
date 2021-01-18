import java.util.ArrayList;
/**
 * Write a description of class Map here.
 *
 * @author (Brian Ruszkowski)
 * @version (17/01/2021)
 */
public class Map
{
    private Room outside; 
    private Room theater;
    private Room pub;
    private Room lab;
    private Room office;
    private Room tennisCourt;
    private Room libary;
    private Room cafe;
    
    private ArrayList<Room> room;
    
    private Room startRoom;
    
    /**
     * A class for the map for the player.
     */
    public Map()
    {
        room = new ArrayList<Room>();
        createRooms();
    }

    /**
     * Creates all the rooms and link their exits together.
     */
    private void createRooms()
    {                      
        createOutsideRoom();        
        createTheatre();
        createTennisCourt();
        createLibary();
        createCafe();
                        
        startRoom = outside;
    }
    
    /**
     * Creates a room for the outside.
     */
    private void createOutsideRoom()
    {
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
    }
    
    /**
     * Creates a room for the theatre.
     */
    private void createTheatre()
    {
      theater = new Room("in a lecture theater");
      theater.setExit("west", outside);  
    }

    /**
     * Creates a room for the pub.
     */
    private void createPub()
    {
        pub = new Room("in the campus pub");
        pub.setExit("east", outside);
    }
    
    /**
     * Creates a room for the lab.
     */
    private void createLab()
    {
        lab = new Room("in a computing lab");
        lab.setExit("north", outside);
        lab.setExit("east", office);
    }
    
    /**
     * Creates a room for the office.
     */
    private void createOffice()
    {
        office = new Room("in the computing admin office");
        office.setExit("west", lab);  
    }    
    
    /**
     * Creates a room for the tennis court.
     */
    public void createTennisCourt()
    {
        tennisCourt = new Room("Grass tennis court");
        tennisCourt.setExit("south", outside);
        outside.setExit("north", tennisCourt);
    }
    
    /**
     * Creates a room for the libary.
     */
    public void createLibary()
    {
        libary = new Room("Inside libary ");
        libary.setExit("south", office);
        libary.setExit("west", cafe);
    }
    
    /**
     * Creates a room for the cafe.
     */
    public void createCafe()
    {
        cafe = new Room("an inside cafe for students");
        cafe.setExit("east", libary);
    }
        
    /**
     * A start point for the player.
     */
    public Room getStartRoom()
    {
        return startRoom;
    }
    
}
