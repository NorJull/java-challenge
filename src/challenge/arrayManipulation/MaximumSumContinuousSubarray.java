package challenge.arrayManipulation;

public class MaximumSumContinuousSubarray {
    public static void main(String[] args) {
        int[] inputArray = {1, 2, -3, 11, -12, -7, -5, 12};
        System.out.println(calculateMaximunSum(inputArray));
    }

    static int calculateMaximunSum(int[] inputArray) {
        int maxSum = inputArray[0];
        int currentSum = maxSum;

        for (int j = 1; j < inputArray.length; j++) {
            currentSum = Math.max(inputArray[j] + currentSum, inputArray[j]);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}