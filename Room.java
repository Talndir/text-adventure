import java.util.ArrayList;

/**
    Room which connects to other rooms and holds objects.
*/

public class Room
{
    /**
        Constructs a room.
    */
    public Room(int id, String name, String description)
    {
        this.id = id;
        this.name = new String(name);
        this.description = new String(description);
        this.rooms = new ArrayList<Room>();
        this.items = new Inventory();

        for (int i = 0; i < Directions.size; ++i)
            this.rooms.add(null);
    }

    /**
        Connects to an existing room, one way only.
        @param r Room to connect to.
        @param d Direction of this room to connect from.
    */
    public void connect(Room r, int d)
    {
        rooms.set(d, r);
    }

    /**
        Disconnects a room, one way only.
        @param d The direction to disconnect.
    */
    public void disconnect(int d)
    {
        rooms.set(d, null);
    }
    
    /**
        Takes an item from the room.
        @param id ID of the item to take.
        @param qty How many of the item to take.
        @return The item taken, with quantity taken.
    */
    public boolean takeItem(int id, int qty)
    {
        return items.remove(id, qty);
    }

    /**
        Puts an item into the room.
        @param x Item to add.
    */
    public void putItem(int id, int qty)
    {
        items.add(id, qty);
    }

    /**
        Gets room in specified direction, may be null.
        @param d Direction of room to get.
    */
    public Room getRoom(int d)
    {
        return rooms.get(d);
    }

    /**
        Prints room info on entry.
    */
    public void print()
    {
        if (visited)
        {
            System.out.println("You are in " + name + ".");
            items.printAll();
        }
        else
        {
            this.printDesc();
            visited = true;
        }
    }

    /**
        Prints the long description of the room.
    */
    public void printDesc()
    {
        System.out.println(description);
        items.printAll();
    }
    
    private final int id;
    private final String name;
    private final String description;
    private final Inventory items;
    private final ArrayList<Room> rooms;
    private boolean visited = false;
}
