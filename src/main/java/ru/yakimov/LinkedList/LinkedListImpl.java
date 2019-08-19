package ru.yakimov.LinkedList;


import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedListImpl<E> implements LinkedList<E> {
    protected Node<E> firstElement;
    protected int size;

    @Override
    public void insertFirst(E value) {
        Node<E> newElement = new Node<>(value);
        newElement.next = firstElement;
        firstElement = newElement;
        size++;

    }

    @Override
    public E removeFirst() {
        if(isEmpty())
            return null;
        E removedElement = firstElement.value;
        firstElement = firstElement.next;
        size--;
        return removedElement;
    }

    @Override
    public boolean remove(E value) {

        Node<E> elementBefore = null;
        Node<E> element = firstElement;
        while(element!= null){
            if(element.value.equals(value))
                break;
            elementBefore = element;
            element = element.next;
        }
        if(element==null)
            return false;
        else if(element == firstElement)
            firstElement = element.next;
        else
            elementBefore.next = element.next;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> element = firstElement;
        while(element!=null){
            if(value.equals(element.value))
                return true;
            element = element.next;
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("---------------------");
        Node<E> element = firstElement;
        while(element != null){
            System.out.println(element.value);
            element = element.next;
        }
        System.out.println("---------------------");
    }

    @Override
    public E getFirstValue() {

        return firstElement.value;
    }

    public Node<E> getFirst() {
        return firstElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement==null;
    }

    @SuppressWarnings("unchecked")
    public E[] getArr(){
        E[] valueArr = (E[]) new Object[size];
        Node<E> nodeElement = firstElement;
        for (int i = 0; i < size ; i++) {
            valueArr[i] = nodeElement.value;
            nodeElement = nodeElement.next;
        }
        return valueArr;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        for (E value: this) {
            action.accept(value);
        }
    }

    private class Itr implements Iterator<E>{
        private int cursor;
        private LinkedListImpl.Node<E> element = firstElement;
        private E valueLastElement;
        @Override
        public boolean hasNext() {
            return cursor!= size;
        }


        @Override
        public E next() {
            if(element == null)
                throw new NullPointerException("There is't element");
            else{
                valueLastElement = element.value;
                element = element.next;
                cursor++;
            }
            return valueLastElement;
        }

        @Override
        public void remove() {
            LinkedListImpl.this.remove(valueLastElement);
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            while(this.hasNext()){
                action.accept(this.next());
            }
        }
    }
}
