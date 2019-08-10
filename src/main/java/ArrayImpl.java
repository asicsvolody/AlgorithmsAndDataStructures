import java.util.Arrays;
import java.util.Objects;

public class ArrayImpl<E> implements Array<E>{

    private int size;
    private E[] data;

    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public ArrayImpl(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }



    @Override
    public void add(E value) {
        checkGrow();
        data[size++] = value;

    }

    private void checkGrow() {
        if(size == data.length){
            data = Arrays.copyOf(data,size*2);
        }
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        if(index !=-1){
            return removeByIndex(index)!= null;
        }
        return false;
    }

    @Override
    public E removeByIndex(int index) {
        checkIndex(index);
        E result = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        data[--size] = null;
        return result;
    }

    private void checkIndex(int index) {
        if(index >= 0 && index < size)
            return;
        throw new IndexOutOfBoundsException("Invalid index value: "+ index +"; array size is:"+ data.length);
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i <size ; i++) {
            if(Objects.equals(value,data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        for (int i = 0; i <size ; i++) {
            System.out.println(data[i]);
        }
        System.out.println("------------------");

    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
