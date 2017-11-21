import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;

/**
    Text adventure game.
*/

public class TextAdventure
{
    public static void main(String args[])
    {
        System.out.println("Test");
    }
    
    /**
        Creates all the rooms in a file ./data/rooms.data.
    */
    private void addRooms()
    {
        BufferedReader in = new BufferedReader("data/rooms.data");

        String line;
        int id;
        String name, desc;
        
        while ((line = in.readLine()) != null)
        {
            // Read ID, name and description
            id = Integer.parseInt(line);
            line = in.readLine();
            desc = in.readLine();

            // Create room
            Room r = new Room(id, name, desc);

            //Read items
            while ((line = in.readLine()) != "#")
            {
                String[] split = line.split(" ");
                r.putItem(
                    Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            }

            rooms.add(r);
        }
    }

    /**
        Loads all items into the item index from ./data/items.data.
    */
    private static void addItems()
    {
    }

    /**
        Getter for item, by ID.
        @param id ID of item to get.
        @return Item of that ID from the item index.
    */
    public static Item getItem(int id)
    {
    }

    private ArrayList<Room> rooms;
    private Player player;
    
    public static ArrayList<Item> itemIndex;
    public static HashMap<String, int> itemNameMap;
    public static Map<int, Room> itemIdMap;
}
