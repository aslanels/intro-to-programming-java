package de.tum.in.ase;

// TODO: make it implement the interface MyList
public class LinkedList<T> implements MyList<T> {
    // TODO: add attributes
    private ListNode<T> first;
    private ListNode<T> last;

    // TODO: add a constructor

    public LinkedList() {
    }

    // TODO: add getters and setters

    public ListNode<T> getFirst() {
        return first;
    }

    public void setFirst(ListNode<T> first) {
        this.first = first;
    }

    public ListNode<T> getLast() {
        return last;
    }

    public void setLast(ListNode<T> last) {
        this.last = last;
    }

    // TODO: implement interface methods

    @Override
    public int size() {
        int size = 0;
        for ( ListNode<T> x = first; x != null; x =x.getNext()){
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(T t) {

        return indexOf(t) != -1;
    }

    public void add(T t) {
       ListNode<T> l = last;
       ListNode<T> newNode = new ListNode<>(t,l,null);
       last = newNode;
       if (l == null){
           first = newNode;
       } else {
           l.setNext(newNode);
       }
    }

    @Override
    public void remove(T t) {
        if (t == null){
            for (ListNode<T> x = first; x != null; x = x.getNext()){
                if (x.getValue() == null){
                    ListNode<T> next = x.getNext();
                    ListNode<T> prev = x.getPrevious();

                    if (prev == null){
                        setFirst(next);
                    } else {
                        prev.setNext(next);
                        x.setPrevious(null);
                    }

                    if (next == null){
                        last = prev;
                    } else {
                        next.setPrevious(prev);
                        x.setNext(null);
                    }
                }
            }
        } else {
            for (ListNode<T> x = first; x != null; x = x.getNext()){
                if (t.equals(x.getValue())){
                    ListNode<T> next = x.getNext();
                    ListNode<T> prev = x.getPrevious();

                    if (prev == null){
                        setFirst(next);
                    } else {
                        prev.setNext(next);
                        x.setPrevious(null);
                    }

                    if (next == null){
                        last = prev;
                    } else {
                        next.setPrevious(prev);
                        x.setNext(null);
                    }
                }
            }
        }
    }

    @Override
    public void clear() {

        for (ListNode<T> x =first; x != null; ){
            ListNode<T> next = x.getNext();
            x.setValue(null);
            x.setNext(null);
            x.setPrevious(null);
            x = next;
        }
        first = last = null;
    }

    @Override
    public T get(int index) {
        if ( index >= this.size() || index < 0){
            throw new IndexOutOfBoundsException("List index is out of bound");
        }
        int i = 0;
        ListNode<T> returnNode = this.first;
        while (i < index){
            returnNode = returnNode.getNext();
            i++;
        }
        return returnNode.getValue();
    }

    @Override
    public void add(int index, T element) {

        if ( !(index >=0 && index <= this.size())){
            throw new IndexOutOfBoundsException("List index is out of bound");
        }

        if ( index == this.size() ){
            this.add(element);
        }else {
            int i = 0;
            ListNode<T> succ = this.first;
            while (i < index){
                succ = succ.getNext();
                i++;
            }
            ListNode<T> pred = succ.getPrevious();

            ListNode<T> newNode = new ListNode<>(element,pred,succ);
            succ.setPrevious(newNode);

            if (pred == null){
                first = newNode;
            }else {
                pred.setNext(newNode);
            }

        }
    }

    @Override
    public T remove(int index) {

        if ( !(index >=0 && index <= this.size())){
            throw new IndexOutOfBoundsException("List index is out of bound");
        }
        int i = 0;
        ListNode<T> x = first;
        while (i < index){
            x = x.getNext();
            i++;
        }

        T element = x.getValue();
        ListNode<T> next = x.getNext();
        ListNode<T> prev = x.getPrevious();

        if (prev == null){
            setFirst(next);
        } else {
            prev.setNext(next);
            x.setPrevious(null);
        }

        if (next == null){
            setLast(prev);
        } else {
            next.setPrevious(prev);
            x.setNext(null);
        }

        return element;
    }

    @Override
    public int indexOf(T t) {
        int index = 0;

        if (t == null){
            for (ListNode<T> x = first; x != null; x = x.getNext() ){
                if (x.getValue() == null)
                    return index;
                index++;
            }
        }else {
            for (ListNode<T> x = first; x != null; x = x.getNext()){
                if (t.equals(x.getValue()))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public String toString() {

        StringBuilder myString = new StringBuilder("[");

        for (int i = 0; i < this.size(); i++){
            myString.append( get(i));

            if ( i < this.size() -1 )   {
                myString.append( ", ");
            }
        }

        myString.append("]");

        return String.valueOf(myString);
    }
}
