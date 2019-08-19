import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yakimov.BidirectionalList.BidirectionalListImpl;

import java.util.Iterator;
public class BidirectionalListImplTest {

    private BidirectionalListImpl<Integer> bidirectionalList;

    @Before
    public void init() {
        bidirectionalList = new BidirectionalListImpl<>();
    }

    @Test
    public void insertFirstTest() {
        bidirectionalList.insertFirst(3);
        bidirectionalList.insertFirst(2);
        bidirectionalList.insertFirst(1);
        Assert.assertArrayEquals(new Integer[]{1,2,3},bidirectionalList.getArr());


    }

    @Test
    public void insertLastTest() {
        bidirectionalList.insertLast(3);
        bidirectionalList.insertLast(2);
        bidirectionalList.insertLast(1);
        Assert.assertArrayEquals(new Integer[]{3,2,1},bidirectionalList.getArr());
    }

    @Test
    public void removeFirstTest() {
        bidirectionalList.insertFirst(3);
        bidirectionalList.insertFirst(2);
        bidirectionalList.insertFirst(1);
        bidirectionalList.removeFirst();
        Assert.assertArrayEquals(new Integer[]{2,3},bidirectionalList.getArr());



    }

    @Test
    public void removeLastTest() {
        bidirectionalList.insertFirst(3);
        bidirectionalList.insertFirst(2);
        bidirectionalList.insertFirst(1);
        bidirectionalList.removeLast();
        Assert.assertArrayEquals(new Integer[]{1,2},bidirectionalList.getArr());

    }

    @Test
    public void removeTest() {
        bidirectionalList.insertFirst(3);
        bidirectionalList.insertFirst(2);
        bidirectionalList.insertFirst(1);
        bidirectionalList.remove(2);
        Assert.assertArrayEquals(new Integer[]{1,3},bidirectionalList.getArr());
    }

    @Test
    public void containsTest() {
        bidirectionalList.insertFirst(3);
        bidirectionalList.insertFirst(2);
        bidirectionalList.insertFirst(1);
        Assert.assertTrue(bidirectionalList.contains(3));

    }

    @Test
    public void getFirstValueTest() {
        bidirectionalList.insertFirst(3);
        bidirectionalList.insertFirst(2);
        bidirectionalList.insertFirst(1);
        Assert.assertEquals(Integer.valueOf(1),bidirectionalList.getFirstValue());
    }

    @Test
    public void getLastValueTest() {
        bidirectionalList.insertFirst(3);
        bidirectionalList.insertFirst(2);
        bidirectionalList.insertFirst(1);
        Assert.assertEquals(Integer.valueOf(3),bidirectionalList.getLastValue());
    }
    @Test
    public void getFirstTest() {
        bidirectionalList.insertFirst(3);
        bidirectionalList.insertFirst(2);
        bidirectionalList.insertFirst(1);
        Assert.assertEquals(Integer.valueOf(1), bidirectionalList.getFirst().value);

    }

    @Test
    public void getLastTest() {
        bidirectionalList.insertFirst(3);
        bidirectionalList.insertFirst(2);
        bidirectionalList.insertFirst(1);
        Assert.assertEquals(Integer.valueOf(3), bidirectionalList.getLast().value);

    }

    @Test
    public void hasNextItr() {
        bidirectionalList.insertFirst(3);
        Iterator<Integer> iterator = bidirectionalList.iterator();
        Assert.assertTrue(iterator.hasNext());
    }

    @Test(expected = NullPointerException.class)
    public void nextItr() {
        bidirectionalList.insertFirst(3);
        bidirectionalList.insertFirst(2);
        bidirectionalList.insertFirst(1);
        Iterator<Integer> iterator = bidirectionalList.iterator();

        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        Assert.assertEquals(Integer.valueOf(2), iterator.next());
        Assert.assertEquals(Integer.valueOf(3), iterator.next());
        Assert.assertNull(iterator.next());
    }

    @Test(expected = NullPointerException.class)
    public void removeIterTest() {
        bidirectionalList.insertFirst(3);
        bidirectionalList.insertFirst(2);
        bidirectionalList.insertFirst(1);
        Iterator<Integer> iterator = bidirectionalList.iterator();

        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        Assert.assertEquals(Integer.valueOf(2), iterator.next());
        iterator.remove();
        Assert.assertEquals(Integer.valueOf(3), iterator.next());
        Assert.assertArrayEquals(new Integer[]{1,3},bidirectionalList.getArr());
        Assert.assertNull(iterator.next());

    }
}