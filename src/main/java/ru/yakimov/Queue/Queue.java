package ru.yakimov.Queue;

import ru.yakimov.ICollections;

public interface Queue<E> extends ICollections {

    boolean insert(E value);

    E remove();

    E peek();
}

