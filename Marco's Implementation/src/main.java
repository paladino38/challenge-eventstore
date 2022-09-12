import classes.EventStore;
import classes.event;
public class main {

    public static void main(String args[])
    {
        EventStore keep = new EventStore();
        event test = new event("test event", 10);
        event test2 = new event("bigger event ", 30);
        keep.insert(test);
        keep.insert(test2);
        keep.moveNext();
        keep.remove();
        keep.remove();
        keep.remove();
        keep.remove();
        keep.print();
    }
}