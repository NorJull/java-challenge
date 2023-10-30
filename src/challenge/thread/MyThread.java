package challenge.thread;

public class MyThread implements Runnable{

    @Override
    public void run() {

        System.out.println("Im in the MyThread thread!");
        //     System.out.println("Im  MyThread, status: " +  getState());

        System.out.println("Im  MyThread and Im going to sleep!");
        try {
            //  System.out.println("Im  MyThread, status: " +  getState());
            synchronized (this) {
                wait(5000);
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Im  MyThread and I finished sleeping!");
    }

}
