package Java8.compleatableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App {
    public static void main(String[] args) {
        final String str = "myString";

        CompletableFuture<Void> result
                = CompletableFuture.supplyAsync(() -> changeString(str))
                .handle((String t, Throwable ex) -> {
                    if(ex!=null)
                        return "exception";
                    else return t;
                })
                .thenAccept(System.out::println);

        CompletableFuture<Void> result2
                = CompletableFuture.supplyAsync(() -> changeString(str))
                .acceptEither(CompletableFuture.supplyAsync(() -> changeString(str)),(t)-> System.out.println(t) );

        final CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> changeString1(str))
                .applyToEither(CompletableFuture.supplyAsync(() -> changeString1(str)), t -> t + "test")
                .thenAccept(System.out::println);
        try {
            voidCompletableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static String  changeString(String str) throws RuntimeException {
       String result = str+"test";
       if(result.length()>23235) {
           throw new RuntimeException("lala");
       }
       return result;
    }

    private static String  changeString1(String str){
        Random random = new Random();
        int n = random.nextInt(10);
        try {
            Thread.sleep(n*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = str+n;
        System.out.println(result);
        return result;
    }

}
