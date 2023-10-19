package challenge.stringManipulation;

import java.util.Stack;

public class BalancedBrackets {
    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     * string: either YES or NO
     *
     * (, ), {, }, [, or ].
     *
     * {(([])[])[]}
        {(([])[])[]]}
     */

    public static String isBalanced(String s) {
        // Write your code here
        int size = s.length();
        Stack<Character> stack = new Stack<>();
        if(size % 2 != 0) {
            return "NO";
        }

        for (int i = 0; i < size; i++) {

            char bracket = s.charAt(i);
            if(bracket == ']') {
                if(stack.empty())
                    return "NO";
                if (!stack.peek().equals('[')) {
                    return "NO";
                } else {
                    stack.pop();
                    continue;
                }
            } else if (bracket == ')') {
                if(stack.empty())
                    return "NO";
                if (!stack.peek().equals('(')) {
                    return "NO";
                } else {
                    stack.pop();
                    continue;
                }
            }  else if (bracket == '}') {
                if(stack.empty())
                    return "NO";
                if (!stack.peek().equals('{')) {
                    return "NO";
                } else {
                    stack.pop();
                    continue;
                }
            } else {
                stack.push(bracket);
            }
        }

        return stack.empty() ? "YES" : "NO";

    }


    public static void main(String[] args) {
        System.out.println(isBalanced("]]"));
    }

}
