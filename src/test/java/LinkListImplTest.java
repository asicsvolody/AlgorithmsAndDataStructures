import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yakimov.LinkedList.LinkedListImpl;

public class LinkListImplTest {

    private LinkedListImpl<Integer> linkList;

    @Before
    public void init(){
        linkList = new LinkedListImpl<>();
    }

    @Test
    public void insertFirstTest() {
        linkList.insertFirst(3);
        linkList.insertFirst(2);
        linkList.insertFirst(1);
        Assert.assertArrayEquals(new Integer[]{1,2,3}, linkList.getArr());
    }

    @Test
    public void removeFirstTest() {
        linkList.insertFirst(3);
        linkList.insertFirst(2);
        linkList.insertFirst(1);
        linkList.removeFirst();
        Assert.assertArrayEquals(new Integer[]{2,3}, linkList.getArr());

    }

    @Test
    public void removeTest() {
        linkList.insertFirst(3);
        linkList.insertFirst(2);
        linkList.insertFirst(1);
        linkList.remove(2);
        Assert.assertArrayEquals(new Integer[]{1,3}, linkList.getArr());


    }

    @Test
    public void containsTest() {
        linkList.insertFirst(3);
        linkList.insertFirst(2);
        linkList.insertFirst(1);
        Assert.assertTrue(linkList.contains(3));

    }

    @Test
    public void containsFalseTest() {
        linkList.insertFirst(3);
        linkList.insertFirst(2);
        linkList.insertFirst(1);
        Assert.assertFalse(linkList.contains(4));

    }
}
