package SortedArr;

public class SortedArrayImpl<E extends Object & Comparable<? super E>> extends ArrayImpl<E> {

    //O(N)
    @Override//[1 2 4 5]
    public void add(E value) {
        checkGrow();
        int index;

        for (index = 0; index < size; index++) {
            if (data[index].compareTo(value) > 0)
                break;
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;
    }

    //O(logN)
    @Override
    public int indexOf(E value) {
        return recBinaryFind(value, 0, size - 1);
    }

    private int recBinaryFind(E value, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (data[mid].equals(value)) {
            return mid;
        }
        else if (data[mid].compareTo(value) > 0) {
            return recBinaryFind(value, low, mid - 1);
        }
        else {
            return recBinaryFind(value, mid + 1, high);
        }
    }
}