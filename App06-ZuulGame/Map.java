import java.util.ArrayList;
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    private Room outside; 
    private Room theater;
    private Room pub;
    private Room lab;
    private Room office;
    
    private ArrayList<Room> room;
    
    private Room startRoom;
    
    public Map()
    {
        room = new ArrayList<Room>();
        createRooms();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {                      
        createOutsideRoom();        
        createTheatre();
        createPub();
        createLab();
        createOffice();
                        
        startRoom = outside;
    }
    
    private void createOutsideRoom()
    {
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
    }
    
    private void createTheatre()
    {
      theater = new Room("in a lecture theater");
      theater.setExit("west", outside);  
    }

    private void createPub()
    {
        pub = new Room("in the campus pub");
        pub.setExit("east", outside);
    }
    
    private void createLab()
    {
        lab = new Room("in a computing lab");
        lab.setExit("north", outside);
        lab.setExit("east", office);
    }
    
    private void createOffice()
    {
        office = new Room("in the computing admin office");
        office.setExit("west", lab);  
    }
    
    public Room getStartRoom()
    {
        return startRoom;
    }
    
}
