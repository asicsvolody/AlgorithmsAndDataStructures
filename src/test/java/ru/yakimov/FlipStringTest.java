package ru.yakimov;

import org.junit.Assert;
import org.junit.Test;
import ru.yakimov.FlipLines.FlipLines;

public class FlipStringTest {

    @Test
    public void flipStringTest() {
        Assert.assertEquals("drow olleH", FlipLines.flipString("Hello word"));
    }
}
