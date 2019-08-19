package ru.yakimov.Stack;

import ru.yakimov.ICollections;

public interface Stack<E> extends ICollections {

    boolean push(E value);

    E pop();

    E peek();
}
