import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayMy <Integer> arrayMy = new ArrayMy<>(1000000);
        Random rnd = new Random();
        for (int i = 1; i <1000000 ; i++) {
            arrayMy.add(rnd.nextInt(1000000));
        }
        arrayMy.display();



    }
}
