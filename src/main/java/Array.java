public interface Array <E>{
    int DEFAULT_CAPACITY = 16;

    void add(E value);

    E removeByIndex(int index);

    boolean remove(E value);

    boolean contains(E value);

    int indexOf(E value);

    boolean isEmpty();

    int size();

    void display();

    default void addAll(E... values){
        for (E value : values) {
            add(value);
        }
    }

    void sortBubble();

    void sortSelect();

    void sortInsert();

}
