package de.thro.inf.prg3.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object>{

    private Element head;
    private int size;
    public SimpleListImpl(){
        head = null;

    }

    //Iterator interface als innere Klasse
    class SimpleIteratorImpl implements Iterator<Object> {
        private Element current = head;

        @Override
        public boolean hasNext() {

            return current != null;
        }

        @Override
        public Object next() {
            Object temp = current.GetObject();
            current = current.GetNext();
            return temp;
        }
    }



    // statische innere Klasse Element
    private static class Element{
        Object item;
        Element next;

        Element(Object o){
            this.item = o;
            this.next = null;
        }
        //Getter
        public Object GetObject(){
            return this.item;
        }
        public Element GetNext(){
            return this.next;
        }
        //Setter
        public void setNext(Element e){
            this.next = e;
        }
    }

	// TODO: Implement the required methods.


    @Override
    public void add(Object o){
       if(head == null){
           head = new Element(o);
       }
       else{
           Element current = head;
           while(current.GetNext() != null){
               current = current.GetNext();
           }
           current.setNext(new Element(o));
        }
       size++;

    }



    public int size(){
        return this.size;

        }

    @Override
    public SimpleList filter(SimpleFilter filter) {
    SimpleListImpl result = new SimpleListImpl();
    for(Object o : this)
        if(filter.include(o))
            result.add(o);
        return result;
    }



    @Override
    public Iterator iterator() {
        return new SimpleIteratorImpl();
    }
}
