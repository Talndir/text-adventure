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
        items = new ArrayList<Pair<Integer, Integer>>();
    }
    
    /**
        Returns index of item with given id.
        @param id ID of item to find.
        @return Index of item with that ID, -1 if it doesn't exist.
    */
    private int find(int id)
    {
        for (int i = 0; i < items.size(); ++i)
        {
            if (items.get(i).getFirst() == id)
                return i;
        }
        
        return -1;
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
            return items.get(r).getSecond();
        else
            return 0;
    }

    /**
        Adds an item to the inventory.
        @param id ID of item to add.
        @param qty Quantity to add.
    */
    public void add(int id, int qty)
    {
        int index = find(id);
        int r = getQuantity(index);

        if (r != 0)
            items.get(index).setSecond(items.get(index).getSecond() + qty);
        else
            items.add(new Pair<Integer, Integer>(id, qty));
    }

    /**
        Removes qty of item with specified id.
        @param id ID of item.
        @param qty Number of items to remove.
        @return The item removed, with quantity removed.
    */
    public boolean remove(int id, int qty)
    {
        int index = find(id);
        int q = getQuantity(index);

        if (q == 0)
        {
            System.out.println("That item doesn't exist");
            return false;
        }
        else if (q < qty)
        {
            System.out.println("There aren't that many items");
            return false;
        }
        
        if (q == qty)
           items.remove(index);
        else
            items.get(id).setSecond(items.get(id).getSecond() - qty);

        return true;
    }

    /**
        Prints all item descriptions.
    */
    public void printAll()
    {
        for (Pair<Integer, Integer> i : items)
        {
            int q = i.getSecond();
            String n = "";
            String r = "";
            Item x = TextAdventure.getItemById(i.getFirst());

            if (q == 1)
            {
                n = x.getName();
                String f = n.substring(0, 1).toLowerCase();

                if (f == "a" || f == "e" || f == "i" || f == "o" || f == "u")
                    r += "An ";
                else
                    r += "A ";
            }
            else
            {
                n = x.getPluralName();
                r += q + " ";
            }

            r += n + ".";
            System.out.println(r);
        }
    }
    
    private final ArrayList<Pair<Integer, Integer>> items;
}
