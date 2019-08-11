
import java.util.Arrays;
import java.util.Objects;

public class ArrayMy <E extends Object & Comparable<? super E>>implements Array<E> {

    protected E[] data;
    protected int size;

    public ArrayMy() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    public ArrayMy(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public void add(E value) {
        checkCapacity();
        data[size++] = value;
    }

    public void checkCapacity() {
        if(size == data.length){
            data = Arrays.copyOf(data, size*2);
        }
    }

    @Override
    public E removeByIndex(int index) {
        checkIndex(index);
        E resValue = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        data[--size] = null;
        return resValue;
    }

    private void checkIndex(int index) {
        if(index >= 0 && index < size)
            return;
        throw new IndexOutOfBoundsException("Wrong index: "+index+" with array size: "+size);
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        if(index!= -1){
            removeByIndex(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value)!= -1;
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
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
        System.out.println("-----------------");
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1 ; i++) {
            for (int j = 0; j < size - 1 -i; j++) {
                if(data[j].compareTo(data[j+1])>0)
                    changeValues(j, j+1);
            }
        }
    }

    private void changeValues(int indexOne, int indexTwo) {
        E remember = data[indexOne];
        data[indexOne] = data[indexTwo];
        data[indexTwo] = remember;
    }


    @Override
    public void sortSelect() {
        for (int i = 0; i < size-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < size ; j++) {
                if (data[j].compareTo(data[minIndex]) <= 0)
                    minIndex = j;
            }
            changeValues(i, minIndex);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size ; i++) {
            E remember = data[i];
            int index = i;
            while(index > 0 && remember.compareTo(data[index - 1]) < 0){
                changeValues(index, index-1 );
                index--;
            }
            data[index] = remember;
        }

    }
}
