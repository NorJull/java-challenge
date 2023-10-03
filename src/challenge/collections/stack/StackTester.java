package challenge.collections.stack;

import java.util.Stack;

public class StackTester {

    public static void main(String[] args) {
        StackWithArrayList<Integer> stack  = new StackWithArrayList<>();

        System.out.println(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.peek());

        System.out.println(stack.pop());

        System.out.println(stack.isEmpty());

    }
}
