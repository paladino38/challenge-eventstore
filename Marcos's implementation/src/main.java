import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.util.Iterator;
import classes.EventStore;
import classes.event;
public class main {

    public static void main(String args[])
    {
        EventStore keep = new EventStore();
        event test = new event("test event", 10);
        event test2 = new event("test event1", 30);
        event test3 = new event("test", 20);
        keep.insert(test);
        keep.insert(test2);
        keep.movenext();
        keep.remove();
        keep.remove();
        keep.remove();
        keep.remove();
            keep.print();
    }
}