package ru.yakimov.Deque;

import ru.yakimov.Queue.Queue;

public interface Deque<E>{

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();

}
