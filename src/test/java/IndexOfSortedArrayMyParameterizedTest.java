import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IndexOfSortedArrayMyParameterizedTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {2,3},
                {1,2},
                {0,1},
                {-1,8}

        });
    }

    private int out;
    private int in;

    public IndexOfSortedArrayMyParameterizedTest(int out, int in) {
        this.out = out;
        this.in = in;
    }

    private SortedArrayMy<Integer> sortedArr;

    @Before
    public void init(){
        sortedArr = new SortedArrayMy<>();
        sortedArr.add(3);
        sortedArr.add(2);
        sortedArr.add(1);
    }

    @Test
    public void indexOfArrayTest() {
        Assert.assertEquals(out,sortedArr.indexOf(in));
    }



}

