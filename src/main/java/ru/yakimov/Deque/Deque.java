package ru.yakimov.Deque;

public interface Deque<E>{

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();

    E peekLeft();

    E peekRight();

}
