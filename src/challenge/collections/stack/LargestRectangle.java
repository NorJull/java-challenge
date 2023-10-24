package challenge.collections.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LargestRectangle {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     * 2, 5 ,6 ,3 ,6 ,7
     *
     *
     * 0, 1, 2 ...i= 3
     */

    public static long largestRectangle(List<Integer> h) {
        // Write your code here

        Stack<Integer> myStack = new Stack<>();
        long maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < h.size(); i++) {
            while (!myStack.isEmpty() && h.get(myStack.peek()) > h.get(i)) {
               // 6  --(3 - 1 -1
                // int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int height = h.get(myStack.pop());
                int width = myStack.isEmpty() ? i : i - myStack.peek() - 1;
                maxArea = Math.max(maxArea, height* width);
            }
            myStack.push(i);
        }

        while (!myStack.isEmpty()) {
            int height = h.get(myStack.pop());
            int width = myStack.isEmpty() ? h.size() : h.size() - myStack.peek() - 1;
            maxArea = Math.max(maxArea, height* width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        List<Integer> h = Arrays.asList(1, 2, 3, 1);
        System.out.println(largestRectangle(h));
    }
}
