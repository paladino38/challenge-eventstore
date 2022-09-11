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
        while (it.hasNext()){
            event e = (event)it.next();
            if(e.type() == type){
                System.out.println("removing element with type " + e.type());
                it.remove();
                if(indexc == maxsize){ //
                    indexc--;
                }
                maxsize--;

            }

        }
    }
    public Iterator<event> query(String type, long startime, long endTime){
        LinkedList<event> copy = new LinkedList<>();
        Iterator<event> it = store.iterator();
        while (it.hasNext()) {
            event e = (event) it.next();
            if(e.type() == type && e.timestamp() > startime && endTime > e.timestamp()){
                copy.add(e);
            }
        }
        Iterator<event> ic = copy.iterator();
        return ic;
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
    public boolean movenext(){
       try{

            if(maxsize > indexc){
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
        while (it.hasNext()) {
            event e = (event) it.next();
            System.out.println(e.type() +" "+ e.timestamp());
            }
    }
    public void remove(){
             try{
                if(maxsize >=1) { // check if there's any event to remove
                    store.remove(indexc);
                    maxsize--;
                    if (indexc > 0) {
                        indexc--;

                    }
                }
            }catch(ConcurrentModificationException nexc) {
                System.out.println("there´s nothing here yet");
                System.exit(0);

            }

    }
}

