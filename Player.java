/**
    Player class, holds position, status and inventory.
*/

public class Player
{
    /**
        Creates a player instance, which there should only ever be one of.
    */
    public Player()
    {
    }
    
    /**
        Picks up qty of item with given ID, if present in current room.
        @param id ID of the item to pick up.
        @param qty How many of that item to pick up.
    */
    public void pickItem(int id, int qty)
    {
        x = currentRoom.items.indexOf(new item(id);
        
        if (x == -1)
        {
            System.out.println("That item isn't here");
            return;
        }

        q = currentRoom.items.get(x).getQuantity;

        if (qty > q)
        {
            System.out.println("There aren't that many items here");
            return;
        }

    }

    /**
        Drops qty of item with given ID, if player has that many of that item.
        @param id ID of the item to drop.
        @param qty How many of that item to drop.
    */
    public void dropItem(int id, int qty)
    {
        
    }

    private Room currentRoom;
    private Inventory inventory;
}
