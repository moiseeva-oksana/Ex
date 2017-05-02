package Java8.compleatableFuture;

import java.util.concurrent.CompletableFuture;

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
    }

    private static String  changeString(String str) throws RuntimeException {
       String result = str+"test";
       if(result.length()>5) {
           throw new RuntimeException("lala");
       }
       return result;
    }
}
