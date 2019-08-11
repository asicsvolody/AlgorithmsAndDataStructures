import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayMyUnitTests {

    private ArrayMy<Integer> arrayMy;

    @Before
    public void init(){
        arrayMy = new ArrayMy<>();
        arrayMy.add(7);
        arrayMy.add(2);
        arrayMy.add(9);
        arrayMy.add(4);
        arrayMy.display();
    }

    @Test
    public void addTest(){
        arrayMy.add(1);
        Assert.assertEquals("Check size of Array",5, arrayMy.size);
    }

    @Test
    public void removeByIndexTest(){
        Assert.assertEquals("Check result of removeByIndex",9,(long)arrayMy.removeByIndex(arrayMy.indexOf(9)));
        Assert.assertEquals("Check size of Array",3, arrayMy.size);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void removeByIndexExceptionTest(){
        Assert.assertEquals("Check exception of removeByIndex",9,(long)arrayMy.removeByIndex(9));

    }

    @After
    public void shutdown(){
        arrayMy.display();
    }


}
