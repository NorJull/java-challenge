package challenge.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TheMaximumSubArray {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        // Write your code here

        List<Integer> maximums = new ArrayList<>(2);
        maximums.add(arr.get(0));
        maximums.add(0);
        int currentMax = arr.get(0);

        for (int i = 1 ; i < arr.size(); i++) {
            currentMax = Math.max(currentMax + arr.get(i), arr.get(i));

            maximums.set(0, Math.max(currentMax, maximums.get(0)));

            if(arr.get(i) > 0) {
                maximums.set(1, maximums.get(1) + arr.get(i));
            }
        }

        if(arr.get(0) > 0) {
            maximums.set(1, maximums.get(1) + arr.get(0));
        } else if (maximums.get(1) == 0) {
            Integer max = arr.stream().max(Comparator.naturalOrder()).get();
            maximums.set(1, max);
        }
        return maximums;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarray(Arrays.asList(2,3,-7,4,5,-11,4,3)));
    }
}
