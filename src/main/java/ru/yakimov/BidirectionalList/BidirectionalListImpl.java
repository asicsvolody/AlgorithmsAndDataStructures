package ru.yakimov.BidirectionalList;


import java.util.Iterator;
import java.util.function.Consumer;

public class BidirectionalListImpl <E> implements BidirectionalList <E>  {
    private Node<E> firstElement;
    private Node<E> lastElement;
    private int size;

    @Override
    public void insertFirst(E value) {
        Node<E> newElement = new Node<>(value);
        if(isEmpty()){
            firstElement = newElement;
            lastElement = firstElement;
        }else{
            newElement.next = firstElement;
            firstElement.before = newElement;
            firstElement = newElement;
        }
        size++;
    }

    @Override
    public void insertLast(E value) {
        Node<E> newElement = new Node<>(value);
        if(isEmpty()){
            firstElement = newElement;
            lastElement = firstElement;
        }else{
            newElement.before = lastElement;
            lastElement.next = newElement;
            lastElement = newElement;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty())
            return null;
        E value = firstElement.value;
        if(size ==1){
            firstElement = null;
            lastElement = null;
        }else{
            firstElement = firstElement.next;
            firstElement.before = null;
        }
        size--;
        return value;
    }

    @Override
    public E removeLast() {
        if(isEmpty())
            return null;
        E value = lastElement.value;
        if(size == 1){
            firstElement = null;
            lastElement = null;
        } else{
            lastElement = lastElement.before;
            lastElement.next = null;
        }
        size--;
        return value;
    }

    @Override
    public boolean remove(E value) {
        Node <E> elementBefore = null;
        Node <E> element = firstElement;
        while(element!= null){
            if(element.value.equals(value)){
                break;
            }
            elementBefore = element;
            element = elementBefore.next;
        }
        if(element == null)
            return false;
        else if(firstElement == element)
            removeFirst();
        else if(lastElement == element)
            removeLast();
        else{
            elementBefore.next= element.next;
            element.next.before = elementBefore;
            size--;
        }
        return false;
    }

    @Override
    public boolean contains(E value) {
        Node<E> element = firstElement;
        while (element != null){
            if(element.value.equals(value))
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

    @Override
    public E getLastValue() {
        return lastElement.value;
    }

    @Override
    public Node<E> getFirst() {
        return firstElement;
    }

    @Override
    public Node<E> getLast() {
        return lastElement;
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
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public E[] getArr(){
        E[] valueArr = (E[]) new Object[size];
        BidirectionalList.Node<E> nodeElement = firstElement;
        for (int i = 0; i < size ; i++) {
            valueArr[i] = nodeElement.value;
            nodeElement = nodeElement.next;
        }
        return valueArr;
    }

    private class Itr implements Iterator<E>{
        private int cursor;
        private Node<E> element = firstElement;
        @Override
        public boolean hasNext() {
            return cursor!= size;
        }


        @Override
        public E next() {
            E  resValue;
            if(firstElement == null)
                throw new NullPointerException("There is't element");
            else{
                resValue = element.value;
                element = element.next;
                cursor++;
            }
            return resValue;
        }

        @Override
        public void remove() {
            E value = element.before.value;
            BidirectionalListImpl.this.remove(value);
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }
}
