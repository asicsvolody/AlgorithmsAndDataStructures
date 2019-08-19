package ru.yakimov.TwoSideLinkedList;

import ru.yakimov.LinkedList.LinkedList;

public interface TwoSideLinkedList<E> extends LinkedList<E> {
    void insertLast(E value);
}
