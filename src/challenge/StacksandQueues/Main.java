package challenge.StacksandQueues;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(12);
        queue.enqueue(14);
        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.peek());
        queue.enqueue(71);
        queue.enqueue(63);
        System.out.println(queue.peek());
       /* 1 12
        1 14
        3
        2
        3
        1 71
        1 63
        3*/
    }
}
