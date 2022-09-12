package classes;

import java.util.Iterator;
import java.util.*;
import classes.event;
public class EventStore {
    private LinkedList<event> store = new LinkedList<>();
    private int maxsize = 0; // saves the total number of event on the list
    private int indexc = 0; // which position we are in the list
    public void insert(event event){
        System.out.println("event was added");
        store.add(event);
        maxsize++; // increse number of elements on the list
    }

    public void removeAll(String type){
        Iterator<event> it = store.iterator();
        int cont = 0; // cont the position
        while (it.hasNext()){
            event e = (event)it.next();
            cont++;
            if(e.type() == type){
                System.out.println("removing element with type " + e.type());
                it.remove();
                if(cont <= indexc){ // if our current position is bigget than cont we have to decrease indexc
                    indexc--;
                }
                maxsize--;

            }

        }
    }
    public Iterator<event> query(String type, long starTime, long endTime){
        LinkedList<event> copy = new LinkedList<>(); // a list to store a copy of the values that fit with the parameters we pass
        Iterator<event> it = store.iterator();
        while (it.hasNext()) {
            event e = (event) it.next(); // receives the current event
            if(e.type() == type && e.timestamp() > starTime && endTime > e.timestamp()){ // check if the event have the right type and the timestamp is between startime and endtime
                copy.add(e); // add to the copy list the event
            }
        }
        Iterator<event> ic = copy.iterator(); // iterator for the list with the copy values
        return ic; // return the list
    }

    public event current(){
        try{
           return store.get(indexc); // return de event in the current position
        }catch(ConcurrentModificationException nexc) {
            System.out.println("there´s nothing here yet");
            System.exit(0);

        }
       return null;
    }
    public boolean moveNext(){
       try{

            if(maxsize > indexc){ // check is theres more events forward
                indexc++;
                System.out.println(indexc);
            }
            return true;
       }
        catch (ConcurrentModificationException c){
           System.out.println("theres no next");
           return false;
        }
    }
    public void print(){
        Iterator<event> it = store.iterator();
        System.out.println("--------------------------------------");
        try {
            while (it.hasNext()) {
                event e = (event) it.next();// receive the event on the current position
                System.out.println(e.type() + " " + e.timestamp()); // print the event type and timestamp
            }
        }catch (ConcurrentModificationException c){
            System.out.println("Maybe try again later");
        }
    }
    public void remove(){
             try{
                if(maxsize >=1) { // check if there's any event to remove
                    store.remove(indexc); // remove from the list
                    maxsize--; // decrease maxsize
                    if (indexc > 0) { // if we are not in the first position decrease our current position
                        indexc--;
                    }
                }
            }catch(ConcurrentModificationException nexc) {
                System.out.println("there´s nothing here yet");
                System.exit(0);

            }

    }
}

