import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class Main {

    private static final int COUNT_ELEMENTS = 1_000_000;
    private static final int RANGE_RANDOM = 1_000;
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Runnable> list = List.of(measureTimeOfMethod("sortBubble()", getArrayMy() :: sortBubble),
                measureTimeOfMethod("sortSelect()", getArrayMy() :: sortSelect),
                measureTimeOfMethod("sortInsert()", getArrayMy() :: sortInsert)
                );
        for (Runnable runnable : list) {
            executorService.execute(runnable);

        }
        executorService.shutdown();
    }

    private static Runnable measureTimeOfMethod(String methodName,Runnable method) {
        return () -> {
            long time = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime());
            method.run();
            System.out.println(String.format("Time of %s sort: %s", methodName, TimeUnit.NANOSECONDS.toSeconds(System.nanoTime()) - time));
        };
    }



    @NotNull
    private static ArrayMy<Integer> getArrayMy() {
        ArrayMy <Integer> arrayMy = new ArrayMy<>();
        Random rnd = new Random();
        for (int i = 1; i <COUNT_ELEMENTS; i++) {
            arrayMy.add(rnd.nextInt(RANGE_RANDOM));
        }
        return arrayMy;
    }
}
