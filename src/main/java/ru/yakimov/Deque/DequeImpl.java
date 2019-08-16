package ru.yakimov.Deque;

import ru.yakimov.Queue.QueueImpl;


public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public boolean insertLeft(E value) {
        if(isFull())
            return false;
        if(head == DEFAULT_HEAD)
            head = data.length;
        data[--head] = value;
        size++;
        return true;

    }

    @Override
    public boolean insertRight(E value) {
        return insert(value);
    }

    @Override
    public E removeLeft() {
        return remove();

    }

    @Override
    public E removeRight() {
        if(isEmpty())
            return null;
        if(tail == DEFAULT_TAIL)
            tail = data.length - 1;
        E value = data[tail--];
        size--;
        return value;
    }

    @Override
    public E peekLeft() {
        return peek();
    }

    @Override
    public E peekRight() {
        if(tail == DEFAULT_TAIL)
            tail = data.length - 1;
        return data[tail];
    }
}
