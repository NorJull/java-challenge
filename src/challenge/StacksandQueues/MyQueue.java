package challenge.StacksandQueues;

import java.util.Stack;

public class MyQueue<T> {

    private Stack<T> stack = new Stack<>();
    private Stack<T> auxStack =new Stack<>();

    public void enqueue(T item){
        if(stack.isEmpty()){
            stack.push(item);
            auxStack.push(item);
        } else {
            stack.clear();
            stack.push(item);
            for(int i=auxStack.size() -1; i >= 0; i--){
                stack.push(auxStack.get(i));
            }

            auxStack.push(item);
        }
    }

    public void dequeue() {
        stack.pop();
        auxStack.clear();
        for (int i =0; i < stack.size(); i++){
            auxStack.push(stack.get(i));
        }
    }

    public T peek() {
        return stack.peek();
    }

}
