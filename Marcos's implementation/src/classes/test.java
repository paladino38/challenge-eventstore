package classes;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Iterator;
import java.util.LinkedList;

public class test {
    @Test
    public void testing(){
        event event = new event("some_type", 123L);
        EventStore event1 = new EventStore();
        EventStore event2 = new EventStore();


        event test = new event("test", 10);
        event test2 = new event("test event1", 30);
        event1.insert(event);
        event1.insert(test);
       // event1.insert(test2);
        event2.insert(test);
        event1.query("test event",10,25);
        event1.removeAll("test");
        //THIS IS A WARNING:
        //Some of us (not everyone) are coverage freaks.
        assertNotEquals(event1,event2);
        assertNotNull(event1.query("test event1",5,30));
        assertEquals(123L, event.timestamp());


        assertNotNull(event2);
        assertEquals("some_type",event1.current().type());
        assertEquals(123L,event1.current().timestamp());
        assertEquals(true , event1.movenext());

    }

}
