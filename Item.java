import java.util.ArrayList;
import java.util.Arrays;

/**
    Item which can be in a room or in the player's inventory.
*/

public class Item
{
    /**
        Constructs an item given an id.
    */
    public Item(int id, String names, String pluralName, String description)
    {
        this.id = id;
        this.names = new ArrayList<String>(Arrays.asList(names.split(";")));
        this.pluralName = new String(pluralName);
        this.description = new String(description);
    }

    /**
        Equality override - if IDs are equal then items are equal.
        @param item Item to compare equality to.
        @return Returns True if items have same ID, false otherwise.
    */
    public boolean equals(Item x)
    {
        return (x instanceof Item) && (this.id == x.id);
    }

    /**
        Get ID.
    */
    public int getId()
    {
        return this.id;
    }

    /**
        Gets the singular name of the item.
        @return Singlular name of the item.
    */
    public String getName()
    {
        return names.get(0);
    }

    /**
        Gets the plural name of the item.
        @return Plural name of the item.
    */
    public String getPluralName()
    {
        return pluralName;
    }

    /**
        Prints info about the item.
    */
    public void print()
    {
        System.out.println(this.getName() + ": " + this.description);
    }

    private final int id;
    private final ArrayList<String> names;
    private final String pluralName;
    private final String description;
    private final boolean isCarriable = true;
}
