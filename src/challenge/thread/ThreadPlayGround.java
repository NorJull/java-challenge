package challenge.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPlayGround {

    public static void main(String[] args) throws InterruptedException {
        /*
        ThreadSubClass thread = new ThreadSubClass();
        AtomicInteger myAtomicInteger = new AtomicInteger(1);


        System.out.println("Init"); //NEW

        thread.run();
       // thread.start();

        System.out.println("Finish"); // RUNNABLE

         */

      /*

        Thread thread = new Thread(new MyThread());
        System.out.println("Init"); //NEW
        thread.start(); // 7 secs
        //thread.join();
        //thread.stop();
        System.out.println("Status: " + thread.getState()); // TERMINATED
        System.out.println("Finish"); //

         */

        int numberOfThreads = 4;
       // ExecutorService myThreadPool = Executors.
       // ThreadPoolExecutor
        Thread thread = new Thread(new MyThread());
        ThreadSubClass thread1 = new ThreadSubClass();
        ExecutorService myThreadPool = Executors.newFixedThreadPool(numberOfThreads);

        myThreadPool.submit(thread);
        myThreadPool.submit(thread1);

        myThreadPool.shutdown();




    }
}
