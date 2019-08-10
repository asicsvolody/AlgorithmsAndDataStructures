public interface Array <E>{

    void add(E value);

    boolean remove(int index);

    boolean removeValue(E value);

    boolean conteins(E value);

    int indexOf(E value);

    boolean isEmpty();

    int size();

    void display();

    default void addAll(E... values){
        for (E value : values) {
            add(value);
        }
    }

}
