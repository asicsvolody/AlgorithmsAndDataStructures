package ru.yakimov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yakimov.Deque.DequeImpl;

public class DequeTest {

    private DequeImpl<Integer> deque;

    @Before
    public void init(){
        deque = new DequeImpl<>(16);
    }

    @Test
    public void insertLeftTest() {
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(4);



        Assert.assertArrayEquals(new Integer[]{4,3,2,1},deque.getArr());
    }

    @Test
    public void insertRightTest() {
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(4);


        deque.insertRight(5);

        Assert.assertArrayEquals(new Integer[]{4,3,2,1,5},deque.getArr());
    }

    @Test
    public void removeLeftResTest() {
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);

        Assert.assertEquals(Integer.valueOf(3),deque.removeLeft());
    }

    @Test
    public void removeLeftTest() {
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.removeLeft();

        Assert.assertArrayEquals(new Integer[]{2,1},deque.getArr());
    }

    @Test
    public void removeResRightTest() {
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);

        Assert.assertEquals(Integer.valueOf(1),deque.removeRight());
    }

    @Test
    public void removeRightTest() {
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.removeRight();
        Assert.assertArrayEquals(new Integer[]{3,2},deque.getArr());
    }

    @Test
    public void peekLeftTest() {
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertRight(3);

        Assert.assertEquals(Integer.valueOf(1),deque.peekLeft());
    }

    @Test
    public void peekRightTest() {
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertRight(3);

        Assert.assertEquals(Integer.valueOf(3),deque.peekRight());
    }

    @Test
    public void peekLeftNullTest() {
        Assert.assertNull(deque.peekLeft());
    }

    @Test
    public void peekRightNullTest() {
        Assert.assertNull(deque.peekRight());
    }
}
