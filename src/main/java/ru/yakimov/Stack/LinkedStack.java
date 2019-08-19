package ru.yakimov.Stack;

import ru.yakimov.LinkedList.LinkListImpl;

public class LinkedStack<E> implements Stack<E> {

    private LinkListImpl <E> linkList;

    public LinkedStack() {
        this.linkList = new LinkListImpl<>();
    }

    @Override
    public boolean push(E value) {
        linkList.insertFirst(value);
        return true;
    }

    @Override
    public E pop() {
        return linkList.removeFirst();
    }

    @Override
    public E peek() {
        return linkList.getFirstValue();
    }

    @Override
    public int size() {
        return linkList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    @Override
    public boolean isFull() {
        return linkList.isFull();
    }
}
