package ru.yakimov.stack;

import ru.yakimov.ICollection;

public interface Stack<E> extends ICollection {

    boolean push(E value);

    E pop();

    E peek();


}