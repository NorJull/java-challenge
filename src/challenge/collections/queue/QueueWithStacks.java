package challenge.collections.queue;

import java.util.Stack;

public class QueueWithStacks<T> {

    Stack<T> stack = new Stack<>();
    Stack<T> auxStack = new Stack<>();

    public void enqueue(T item){
        stack.push(item);
    }

    public T dequeue() {
        if(auxStack.isEmpty()) {
            while (!stack.isEmpty()) {
                auxStack.push(stack.pop());
            }
        }
        return auxStack.pop();
    }

    public T peek() {

        if(auxStack.isEmpty()) {
            while (!stack.isEmpty()) {
                auxStack.push(stack.pop());
            }
        }

        return auxStack.peek();
    }
}
