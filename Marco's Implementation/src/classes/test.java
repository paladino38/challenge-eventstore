package classes;
import static org.junit.Assert.*;
import org.junit.Test;


public class test {
    @Test
    public void testing(){
        event event = new event("some_type", 123L);// creat a event
        EventStore event1 = new EventStore();// creat a eventStore
        EventStore event2 = new EventStore();// creat a eventStore


        event test = new event("test", 10);// creat a event
        event1.insert(event);// insert event
        event1.insert(test);
        event2.insert(test);
        event1.query("test",10,25);
        event1.removeAll("test");
        //THIS IS A WARNING:
        //Some of us (not everyone) are coverage freaks.
        assertNotEquals(event1,event2);// testing the query and remoAll functions with this assert
        assertNotNull(event1.query("test event1",5,30));
        assertEquals(123L, event.timestamp());// testing the timestamp


        assertNotNull(event2);
        assertEquals("some_type",event1.current().type());// testign the current and type funtion
        assertEquals(123L,event1.current().timestamp());
        assertEquals(true , event1.moveNext());// testing the moveNext function
        event1.insert(test);
        event1.insert(event);
        event1.remove();
        assertNotEquals(event1,event2);//testing the remove function

    }

}
