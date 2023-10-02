package challenge.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MarkandToys {
    public static int maximumToys(List<Integer> prices, int k) {
        // Write your code here
        int maximumToys = 0;
        int accumulator = 0;

        Collections.sort(prices);

        for(int i= 0; i < prices.size(); i++){
            if(accumulator + prices.get(i) > k)
                break;
            accumulator += prices.get(i);
            maximumToys++;
        }

        return maximumToys;
    }

    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(1,2,3,4,5,6);
        System.out.println(maximumToys(prices, 6));
    }
}
