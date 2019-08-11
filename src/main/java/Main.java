public class Main {
    public static void main(String[] args) {
        SortedArrayMy<Integer> arrayMy = new SortedArrayMy<>();
        arrayMy.add(9);
        arrayMy.add(7);
        arrayMy.add(1);
        arrayMy.add(8);
        arrayMy.add(2);
        arrayMy.add(5);
        arrayMy.add(3);
        arrayMy.add(6);
        arrayMy.add(4);
        arrayMy.display();

        arrayMy.sortBubble();

        arrayMy.display();



    }
}
