import java.util.ArrayList;

/**
    Item which can be in a room or in the player's inventory.
*/

public class Item
{
    /**
        Constructs an item given an id.
    */
    public Item(int id)
    {
        this.id = id;
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
        Get quantity.
        @return The quantity.
    */
    public int getQuantity()
    {
        return this.quantity;
    }

    /**
        Add quantity.
        @param n Amount to add.
    */
    public void add(int n)
    {
        this.quantity += n;
    }

    /**
        Remove quantity.
        @param n Amount to remove.
        @return The item removed, with quantity removed.
    */
    public Item remove(int n)
    {
        Item r = this;
        r.add(n - this.quantity);

        if (n > this.quantity)
            this.quantity = 0;
        else
            this.quantity -= n;

        return r;
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
        return plural;
    }

    private final int id;
    private final ArrayList<String> names = new ArrayList<String>;
    private final String plural = "";
    private final String description = "";
    private final boolean isCarriable = true;
    private int quantity;
}
