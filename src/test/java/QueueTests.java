import org.junit.Before;
import org.junit.Test;
import ru.yakimov.Queue.QueueImpl;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class QueueTests{
    private QueueImpl<Integer> queueInt;

    @Before
    public void init(){
        queueInt = new QueueImpl<>(12);
    }

    @Test
    public void insertTest() {
        queueInt.insert(1);
        queueInt.insert(2);
        queueInt.insert(3);
        assertArrayEquals(new Integer[]{1,2,3}, queueInt.getArr());
    }

    @Test
    public void removeResTest() {
        queueInt.insert(1);
        queueInt.insert(2);
        queueInt.insert(3);

        assertEquals(Integer.valueOf(1), queueInt.remove() );
    }

    @Test
    public void removeTest() {
        queueInt.insert(1);
        queueInt.insert(2);
        queueInt.insert(3);

        queueInt.remove();

        assertEquals(2, queueInt.size());
    }

    @Test
    public void peekArr() {
        queueInt.insert(1);
        queueInt.insert(2);
        queueInt.insert(3);

        assertEquals(Integer.valueOf(1), queueInt.peek());
    }
}
