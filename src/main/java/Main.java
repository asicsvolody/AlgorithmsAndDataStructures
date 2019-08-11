import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Thread(()-> measureTimeOfMethod("sortBubble()", getArrayMy() :: sortBubble)));
        executorService.submit(new Thread(()-> measureTimeOfMethod("sortSelect()", getArrayMy() :: sortSelect)));
        executorService.submit(new Thread(()-> measureTimeOfMethod("sortInsert()", getArrayMy() :: sortInsert)));
        executorService.shutdown();
    }

    private static void measureTimeOfMethod(String methodName,Runnable method){

//        long time = System.currentTimeMillis();

        long time = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime());
        method.run();
        System.out.println("Time of "+methodName+" sort: "+(TimeUnit.NANOSECONDS.toSeconds(System.nanoTime())- time));

//        System.out.println("Time of "+methodName+" sort: "+(System.currentTimeMillis()- time));

    }

    @NotNull
    private static ArrayMy<Integer> getArrayMy() {
        ArrayMy <Integer> arrayMy = new ArrayMy<>();
        Random rnd = new Random();
        for (int i = 1; i <1000000; i++) {
            arrayMy.add(rnd.nextInt(1000));
        }
        return arrayMy;
    }
}
