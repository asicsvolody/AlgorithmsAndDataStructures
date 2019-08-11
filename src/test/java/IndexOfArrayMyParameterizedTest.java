import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IndexOfArrayMyParameterizedTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {0,3},
                {1,2},
                {2,1},
                {-1,8}

        });
    }

    private int out;
    private int in;

    public IndexOfArrayMyParameterizedTest(int out, int in) {
        this.out = out;
        this.in = in;
    }

    private Array<Integer> array;

    @Before
    public void init(){
        array = new ArrayMy<>();
        array.add(3);
        array.add(2);
        array.add(1);
    }

    @Test
    public void indexOfArrayTest() {
        Assert.assertEquals(out,array.indexOf(in));
    }



}
