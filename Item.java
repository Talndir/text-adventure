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
    */
    public void remove(int n)
    {
        if (n > this.quantity)
            this.quantity = 0;
        else
            this.quantity -= n;
    }

    private final int id;
    private final String name = "";
    private final String description = "";
    private final boolean isCarriable = True;
    private int quantity;
}
