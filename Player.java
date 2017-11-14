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
        Picks up qty of item with given ID, in current room.
        @param id ID of the item to pick up.
        @param qty How many of that item to pick up.
    */
    public void pickItem(int id, int qty)
    {
        if (currentRoom.takeItem(id, qty))
            inventory.add(id, qty);
    }

    /**
        Drops qty of item with given ID.
        @param id ID of the item to drop.
        @param qty How many of that item to drop.
    */
    public void dropItem(int id, int qty)
    {
        if (inventory.remove(id, qty))
            currentRoom.putItem(id, qty);
    }

    /**
        Move player to room in direction specified.
        @param d Direction to move in.
    */
    public void move(int d)
    {
        r = currentRoom.getRoom(d)
        if (r == null)
            System.out.println("You can't go that way");
        else
            this.teleport(r);
    }

    /**
        Teleports the player to the given room.
        @param r Room to teleport to.
    */
    public void teleport(Room r)
    {
        currentRoom = r;
    }

    private Room currentRoom;
    private Inventory inventory;
}
