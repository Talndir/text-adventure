import java.util.ArrayList;

/**
    An inventory of items.
*/

public class Inventory
{
    /**
        Creates an ItemList.
    */
    public Inventory()
    {
    }
    
    /**
        Returns index of item with given id.
        @param id ID of item to find.
        @return Index of item with that ID, -1 if it doesn't exist.
    */
    private int find(int id)
    {
        return items.indexOf(new Item(id));
    }

    /**
        Returns quantity of item with specified id.
        @param id Id to look for.
        @return Quantity of that item, 0 if item does not exist.
    */
    public int getQuantity(int id)
    {
        int r = find(id);
        
        if (r != -1)
            return items.get(r).getQuantity();
        else
            return 0;
    }

    /**
        Gets item with the specified id.
        @param id Id to look for.
        @return Item with specified id.
    */
    public Item get(int id)
    {
        return items.get(find(id));
    }

    /**
        Adds an item to the inventory.
        @param x Item to add.
    */
    public void add(Item x)
    {
        int r = this.getQuantity(x.getId());

        if (r != 0)
            items.get(items.indexOf(x)).add(x.getQuantity());
        else
            items.add(x);
    }

    /**
        Removes qty of item with specified id.
        @param id ID of item.
        @param qty Number of items to remove.
    */
    public void remove(int id, int qty)
    {
        int q = this.getQuantity(id);

        if (q == 0)
            System.out.println("That item doesn't exist");
        else if (q < qty)
            System.out.println("There aren't that many items");
        else if (q == qty)
            items.remove(find(id));
        else
            items.get(id).remove(qty);
    }

    private ArrayList<Item> items;
}
