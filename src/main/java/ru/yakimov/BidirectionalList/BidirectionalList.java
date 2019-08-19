package ru.yakimov.BidirectionalList;

import ru.yakimov.LinkedList.LinkedList;

public interface BidirectionalList<E>  extends LinkedList<E> {

    void insertFirst(E value);//

    void insertLast(E value);

    E removeFirst();//

    E removeLast();

    boolean remove(E value);//

    boolean contains(E value);//

    void display();//

    E getFirstValue();//

    E getLastValue();


    BidirectionalList.Node<E> getFirst();

    BidirectionalList.Node<E> getLast();


    @Override
    default boolean isFull() {
        return false;
    }

    class Node<T> {
        public final T value;
        public BidirectionalList.Node<T> next;
        public BidirectionalList.Node<T> before;

        public Node(T value) {
            this.value = value;
        }
    }


}
