package ru.yakimov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yakimov.stack.StackImpl;

public class StackTest {

    private StackImpl<Integer> stack;
    @Before
    public void init(){
        stack = new StackImpl<>(16);
    }

    @Test
    public void pushTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertArrayEquals(new Integer[]{1,2,3}, stack.getArr());
    }

    @Test
    public void popResTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(Integer.valueOf(3), stack.pop());
    }

    @Test
    public void popTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();

        Assert.assertEquals(2, stack.size());
    }

    @Test
    public void peekTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(Integer.valueOf(3),stack.peek());
    }
}
