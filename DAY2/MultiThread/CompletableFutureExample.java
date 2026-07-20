package DAY2.MultiThread;

import java.util.ArrayList;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class CompletableFutureExample {

    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public  static  void main(String[] args) throws InterruptedException, ExecutionException {

//        heavyTask1Starter();
//        heavyTask2Starter();
        heavyTask3();

    }

    public static void heavyTask1Starter() throws InterruptedException {
        long t=System.currentTimeMillis();
        heavyTask1();
        heavyTask1();
        heavyTask1();
        heavyTask1();
        long t1=System.currentTimeMillis();

        System.out.println((t1-t)/1000 + " Seconds");
    }

    public static void heavyTask2Starter() throws InterruptedException, ExecutionException {

        long t=System.currentTimeMillis();

        heavyTask2();
        heavyTask2();
        heavyTask2();
        heavyTask2();


        long t1=System.currentTimeMillis();

        System.out.println((t1-t)/1000 + " Seconds");
    }



    public static  void heavyTask1() throws InterruptedException {


        for(int i=0;i<10;i++)
        {
            sleep(1000);
        }
    }



    public static  void heavyTask2() throws InterruptedException, ExecutionException {

        ArrayList<Future<?>> arrayList = new ArrayList<>();

        for(int i=0;i<10;i++)
        {
            Future<?> s=executorService.submit(()->{
                try {
                    sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            arrayList.add(s);
        }
        for(Future f:arrayList)
        {
            f.get();
        }


    }

    public static void heavyTask3()
    {
//        CompletableFuture<Void> cf= java.util.concurrent.CompletableFuture.supplyAsync(()->{
//            try {
//                heavyTask2Starter();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } catch (ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//            return null;
//        });
//
//         cf.join();
//         return null;

        CompletableFuture.runAsync(()->{
            for(int i=0;i<10;i++)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
