/**
    Pair class, contains two objects.
*/

public class Pair<T, U>
{
    /**
        Pair constructor.
    */
    public Pair()
    {
    }
    
    /**
        Pair constructor.
    */
    public Pair(T a, U b)
    {
        this.a = a;
        this.b = b;
    }
    
    /**
        Returns first element.
        @return First element.
    */
    public T getFirst()
    {
        return a;
    }

    /**
        Sets first element.
        @param a What to set first element to.
    */
    public void setFirst(T a)
    {
        this.a = a;
    }

    /**
        Returns second element.
        @return Second element.
    */
    public U getSecond()
    {
        return b;
    }

    /**
        Sets second element.
        @param b What to set second element to.
    */
    public void setSecond(U b)
    {
        this.b = b;
    }

    private T a = null;
    private U b = null;
}
