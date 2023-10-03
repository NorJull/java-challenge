package challenge.collections.queue;

public class QueueTester {

    public static void main(String[] args) {
        QueueWithStacks<Integer> queue = new QueueWithStacks<>();

        queue.enqueue(10);
        queue.enqueue(16);
        queue.enqueue(17);
        queue.enqueue(12);
        queue.enqueue(14);

        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());


    }
}
