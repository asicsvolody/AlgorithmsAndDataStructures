package ru.yakimov.Queue;

import ru.yakimov.ICollection;

public interface Queue<E> extends ICollection {

    boolean insert(E value);

    E remove();

    E peek();

}
