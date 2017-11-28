import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

/**
    Text adventure class, base class for entire game.
*/

public class TextAdventure
{
    public TextAdventure()
    {
        System.out.println("Creating objects");
        this.rooms = new ArrayList<Room>();
        this.player = new Player();

        System.out.println("Adding rooms");
        this.addRooms();
        System.out.println("Adding items");
        this.addItems();
    }
    
    /**
        Creates all the rooms in a file ./data/rooms.data.
    */
    private void addRooms()
    {
        try
        {
            File file = new File("data/rooms.data");
            BufferedReader in = new BufferedReader(new FileReader(file));

            String line;
            int id;
            String name, desc;
            
            while ((line = in.readLine()) != null)
            {
                // Read ID, name and description
                id = Integer.parseInt(line);
                name = in.readLine();
                desc = in.readLine();
                
                // Create room
                Room r = new Room(id, name, desc);

                //Read items
                while (!(line = in.readLine()).equals("#"))
                {
                    System.out.println("<" + line + ">");
                    String[] split = line.split(" ");
                    r.putItem(
                        Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                }

                rooms.add(r);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: data/rooms.data not found");
        }
        catch (IOException e)
        {
            System.out.println("Error: error reading data/rooms.data");
        }
    }

    /**
        Loads all items into the item index from ./data/items.data.
    */
    private static void addItems()
    {
        try
        {
            File file = new File("data/items.data");
            BufferedReader in = new BufferedReader(new FileReader(file));

            String line;
            int id;
            String names, pluralName, description;
            
            while((line = in.readLine()) != null)
            {
                // Read ID, names, plural name and description
                id = Integer.parseInt(line);
                names = in.readLine();
                pluralName = in.readLine();
                description = in.readLine();
                
                // Create item
                itemIndex.add(new Item(id, names, pluralName, description));

                // Read "#"
                in.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: data/items.data not found");
        }
        catch (IOException e)
        {
            System.out.println("Error: error reading data/items.data");
        }
    }

    /**
        Getter for item, by ID.
        @param id ID of item to get.
        @return Item of that ID from the item index.
    */
    public static Item getItemById(int id)
    {
        return itemIdMap.get(id);
    }

    /**
        Getter for item, by name.
        @param name Name of the item to get.
        @return Item of that name from the item index.
    */
    public static Item getItemByName(String name)
    {
        return getItemById(itemNameMap.get(name));
    }

    private final ArrayList<Room> rooms;
    private final Player player;
    
    private static final ArrayList<Item> itemIndex
        = new ArrayList<Item>();
    private static final HashMap<String, Integer> itemNameMap
        = new HashMap<String, Integer>();
    private static final HashMap<Integer, Item> itemIdMap
        = new HashMap<Integer, Item>();
}
