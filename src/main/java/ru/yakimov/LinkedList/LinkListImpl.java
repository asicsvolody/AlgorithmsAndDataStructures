package ru.yakimov.LinkedList;

import java.util.Iterator;

public class LinkListImpl<E> implements LinkedList<E> {
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
        }
        System.out.println("---------------------");
    }

    @Override
    public E getFirstValue() {

        return firstElement.value;
    }

    @Override
    public Node<E> getFirst() {
        return firstElement;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
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
}
