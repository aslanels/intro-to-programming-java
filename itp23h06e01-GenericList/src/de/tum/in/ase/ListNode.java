package de.tum.in.ase;

public class ListNode<T> {
    // TODO: add attributes
    private ListNode<T> previous;
    private ListNode<T> next;
    private T value;
    // TODO: add 3 constructors as in the problem statement

    public ListNode() {
    }

    public ListNode(T value) {
        this.value = value;
    }

    public ListNode( T value, ListNode<T> previous, ListNode<T> next) {
        this.previous = previous;
        this.next = next;
        this.value = value;
    }

    // TODO: add getters and setters


    public ListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode<T> previous) {
        this.previous = previous;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
