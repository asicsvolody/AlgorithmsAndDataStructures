
public class SortedArrayMy <E extends Object & Comparable<? super E>> extends ArrayMy<E>  {

    @Override
    public void add(E value) {
        checkCapacity();
        int index;
        for (index = 0; index < size ; index++) {
            if(value.compareTo(data[index])<=0){
                break;
            }
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        size++;
    }

    @Override
    public int indexOf(E value) {
        int low = 0;
        int high = size -1;

        while(low <= high){
            int mid = (low+high) /2;
            if(data[mid].equals(value)){
                return mid;
            }
            if(value.compareTo(data[mid]) > 0)
                low = mid -1;
            else
                high = mid +1;

        }
        return -1;
    }
}
