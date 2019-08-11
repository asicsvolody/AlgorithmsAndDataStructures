import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortedArrayMyUnitTest {

    private SortedArrayMy<Integer> sortedArrayMy;

    @Before
    public void init(){
        sortedArrayMy = new SortedArrayMy<>();
        sortedArrayMy.add(7);
        sortedArrayMy.add(2);
        sortedArrayMy.add(9);
        sortedArrayMy.add(4);
        sortedArrayMy.display();
    }

    @Test
    public void addTest(){
        sortedArrayMy.add(1);
        Assert.assertEquals("Check size of Array",5, sortedArrayMy.size);
    }

    @Test
    public void removeByIndexTest(){
        Assert.assertEquals("Check result of removeByIndex",9,(long) sortedArrayMy.removeByIndex(sortedArrayMy.indexOf(9)));
        Assert.assertEquals("Check size of Array",3, sortedArrayMy.size);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void removeByIndexExceptionTest(){
        Assert.assertEquals("Check exception of removeByIndex",9,(long) sortedArrayMy.removeByIndex(9));

    }

    @After
    public void shutdown(){
        sortedArrayMy.display();
    }
}
