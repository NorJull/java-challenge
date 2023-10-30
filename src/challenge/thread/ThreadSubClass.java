package challenge.thread;

public class ThreadSubClass extends Thread{

    @Override
    public void run() {

        System.out.println("Im in the ThreadSubClass thread!");
   //     System.out.println("Im  ThreadSubClass, status: " +  getState());

            System.out.println("Im  ThreadSubClass and Im going to sleep!");
        try {
          //  System.out.println("Im  ThreadSubClass, status: " +  getState());
            synchronized (this) {
                wait(5000);
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Im  ThreadSubClass and I finished sleeping!");

    }
}
