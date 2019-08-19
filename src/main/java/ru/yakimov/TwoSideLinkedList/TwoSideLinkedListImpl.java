package ru.yakimov.TwoSideLinkedList;

import ru.yakimov.LinkedList.LinkedListImpl;

public class TwoSideLinkedListImpl<E> extends LinkedListImpl<E> implements TwoSideLinkedList<E> {

    private Node<E> lastElement;

    @Override
    public void insertLast(E value) {
        Node <E> element = new Node<>(value);

        if(isEmpty())
            firstElement = element;
        else
            lastElement.next = element;
        lastElement = element;
        size++;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if(size==1) {
            lastElement = firstElement;
        }
    }

    @Override
    public E removeFirst() {
        E value = super.removeFirst();
        if(isEmpty())
            lastElement = null;
        return value;
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
        else if(firstElement == element && lastElement == element){
            firstElement = null;
            lastElement = null;
        }
        else if(element == firstElement)
            firstElement = element.next;
        else if(element == lastElement) {
            lastElement = elementBefore;
            lastElement.next = null;
        }
        else
            elementBefore.next = element.next;
        size--;

        return true;
    }
}
