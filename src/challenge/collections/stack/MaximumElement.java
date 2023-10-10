package challenge.collections.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaximumElement {

    /*
    HackerRank Link : https://www.hackerrank.com/challenges/maximum-element/problem?isFullScreen=true
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     *
     *
     * 1 x  -Push the element x into the stack.
2    -Delete the element present at the top of the stack.
3    -Print the maximum element in the stack.
     */

    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        Stack<Integer> elements = new Stack<>();
        List<Integer> indexMaxValues = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < operations.size(); i++) {
            char operation = operations.get(i).charAt(0);
            if (operation == '1') {

                String string = operations.get(i).split(" ")[1];
                Integer number = Integer.parseInt(string);
                elements.push(number);

                if (elements.size() == 1) {
                    //First max value will be in the first index of then stack
                    indexMaxValues.add(0);
                } else {
                    Integer lastIndex = indexMaxValues.get(indexMaxValues.size() - 1);
                    Integer value = elements.get(lastIndex);
                    if (number >= value) {
                        indexMaxValues.add(elements.size() - 1);
                    }
                }
            } else if (operation == '2') {
                Integer number = elements.pop();
                if (elements.size() == indexMaxValues.get(indexMaxValues.size() - 1)) {
                    indexMaxValues.remove(indexMaxValues.size() - 1);
                }
            } else {
                //Add value to the Result array;
                Integer lastIndex = indexMaxValues.get(indexMaxValues.size() - 1);
                Integer value = elements.get(lastIndex);
                result.add(value);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        List<String> queries = Arrays.asList(
                "1 1",
                "1 44",
                "3",
                "3",
                "2",
                "3",
                "3",
                "1 3",
                "1 37",
                "2",
                "3",
                "1 29",
                "3",
                "1 73",
                "1 51",
                "3",
                "3",
                "3",
                "1 70",
                "3",
                "1 8",
                "2",
                "1 49",
                "1 56",
                "1 81",
                "2",
                "1 59",
                "1 44",
                "2",
                "3",
                "3",
                "2",
                "3",
                "3",
                "1 4",
                "3",
                "1 89",
                "2",
                "1 37",
                "1 50",
                "1 64",
                "2",
                "1 49",
                "1 35",
                "1 85",
                "3",
                "1 41",
                "2",
                "3",
                "3",
                "1 86",
                "3",
                "1 60",
                "1 8",
                "3",
                "1 100",
                "3",
                "1 83",
                "3",
                "1 47",
                "2",
                "1 78",
                "2",
                "1 55",
                "1 97",
                "2",
                "3",
                "1 40"
        );

        /*
        *
44
44
1
1
3
29
73
73
73
73
73
73
73
73
73
85
85
85
86
86
100
100
100
        * */
        System.out.println(getMax(queries));
    }
}
