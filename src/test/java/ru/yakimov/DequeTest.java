package ru.yakimov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yakimov.Deque.Deque;
import ru.yakimov.Deque.DequeImpl;

public class DequeTest {
    DequeImpl<Integer> deque;

    @Before
    public void init(){
        deque = new DequeImpl<>(16);
    }

    @Test
    public void insertLeftTest() {
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);

        Assert.assertArrayEquals(new Integer[]{3,2,1},deque.getArr());
    }

    @Test
    public void insertRightTest() {
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);

        deque.insertRight(4);

        Assert.assertArrayEquals(new Integer[]{3,2,1,4},deque.getArr());
    }

    @Test
    public void removeLeftTest() {
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);

        Assert.assertEquals(Integer.valueOf(3),deque.removeLeft());
    }

    @Test
    public void removeRightTest() {
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);

        Assert.assertEquals(Integer.valueOf(1),deque.removeRight());
    }
}
