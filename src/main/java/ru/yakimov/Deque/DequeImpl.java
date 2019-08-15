package ru.yakimov.Deque;

import ru.yakimov.Queue.QueueImpl;


public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public boolean insertLeft(E value) {
        return insert(value);

    }

    @Override
    public boolean insertRight(E value) {
        if(isEmpty())
            return false;
        if(head+1 == data.length){
            head = DEFAULT_TAIL;
        }
        data[++head] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if(isEmpty())
            return null;
        if(tail == DEFAULT_HEAD+1)
            tail = data.length;
        E value = data[--tail];
        size--;
        return value;
    }

    @Override
    public E removeRight() {
        return remove();
    }
}
