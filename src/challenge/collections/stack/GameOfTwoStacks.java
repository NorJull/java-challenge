package challenge.collections.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GameOfTwoStacks {

    /*
    * hackerrank link: https://www.hackerrank.com/challenges/game-of-two-stacks/problem?isFullScreen=true
    * */
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        //Nick's final score is the total number of integers he has removed from the two stacks.
        int indexA = 0;
        int indexB = 0;
        int maxCount = 0;
        int sum = 0;
        int removedItems = 0;

        while(indexA <  a.size() && sum + a.get(indexA)  <= maxSum) {
           sum = sum + a.get(indexA);
           indexA++;
           removedItems++;
           maxCount++;
        }

        while(indexA >= 0) {

            while(indexB <  b.size() && sum + b.get(indexB) <= maxSum) {

                sum = sum + b.get(indexB);
                indexB++;
                removedItems++;

                if(removedItems > maxCount) {
                    maxCount = removedItems;
                }

            }

            if(indexA == 0)
                break;

            indexA--;
            int preRemovedElement = a.get(indexA);
            sum = sum - preRemovedElement;
            removedItems--;

        }


        return maxCount;

    }


    public static void main(String[] args) {
        List<Integer> b = Arrays.asList(0,0,0,0,0,0,5);
        List<Integer> a =  Arrays.asList(5,0,0,0,0,6);
        int maxSum = 10;
        System.out.println(twoStacks(maxSum, a, b));
    }

}
