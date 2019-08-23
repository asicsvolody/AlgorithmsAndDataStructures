package Exponent;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ExponentTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {2,1},
                {4,2},
                {8,3},
                {16,4},
                {32,5},
                {64,6}
        });
    }
    private int result;
    private int exponent;

    public ExponentTest(int result, int exponent) {
        this.result = result;
        this.exponent = exponent;
    }

    @Test
    public void exponentTest() {
        Assert.assertEquals(result, Exponent.exponent(2, exponent));
    }
}