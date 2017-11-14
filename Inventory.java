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
        @return The item removed, with quantity removed.
    */
    public Item remove(int id, int qty)
    {
        int q = this.getQuantity(id);

        if (q == 0)
        {
            System.out.println("That item doesn't exist");
            return null;
        }
        else if (q < qty)
        {
            System.out.println("There aren't that many items");
            return null;
        }
        
        Item r = items.get(id).remove(qty);

        if (q == qty)
           items.remove(find(id));
        
        return r;
    }

    /**
        Prints all item descriptions.
    */
    public void printAll()
    {
        for (Item i : items)
        {
            int q = i.getQuantity();
            String n = "";
            String r = "";

            if (q == 1)
            {
                n = i.getName();
                String f = n.substring(0, 1).toLowerCase();

                if (f == "a" || f == "e" || f == "i" || f == "o" || f == "u")
                    r += "An ";
                else
                    r += "A ";
            }
            else
            {
                n = i.getPluralName();
                r += q + " ";
            }

            r += n + ".";
            System.out.println(r);
        }
    }

    private ArrayList<Item> items;
}
