import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yakimov.TwoSideLinkedList.TwoSideLinkedListImpl;

import static org.junit.Assert.*;

public class TwoSideLinkedListImplTest {
    private TwoSideLinkedListImpl <Integer> twoSideLinkedList ;

    @Before
    public void init() {
        twoSideLinkedList = new TwoSideLinkedListImpl<>();
    }

    @Test
    public void insertFirstTest() {
        twoSideLinkedList.insertFirst(3);
        twoSideLinkedList.insertFirst(2);
        twoSideLinkedList.insertFirst(1);
        assertArrayEquals(new Integer[]{1,2,3}, twoSideLinkedList.getArr());
    }

    @Test
    public void insertLastTest() {
        twoSideLinkedList.insertFirst(3);
        twoSideLinkedList.insertFirst(2);
        twoSideLinkedList.insertFirst(1);
        twoSideLinkedList.insertLast(4);

        Assert.assertArrayEquals(new Integer[]{1,2,3,4}, twoSideLinkedList.getArr());
    }

    @Test
    public void removeFirstTest() {
        twoSideLinkedList.insertFirst(3);
        twoSideLinkedList.insertFirst(2);
        twoSideLinkedList.insertFirst(1);
        twoSideLinkedList.removeFirst();
        assertArrayEquals(new Integer[]{2,3}, twoSideLinkedList.getArr());

    }

    @Test
    public void removeTest() {
        twoSideLinkedList.insertFirst(3);
        twoSideLinkedList.insertFirst(2);
        twoSideLinkedList.insertFirst(1);
        twoSideLinkedList.remove(2);
        assertArrayEquals(new Integer[]{1,3}, twoSideLinkedList.getArr());


    }

}