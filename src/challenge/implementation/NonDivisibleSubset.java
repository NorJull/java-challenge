package challenge.implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonDivisibleSubset {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int maxSubsetCount = 0;
        Map<Integer, Integer> remainders = new HashMap<>();

        for(int i = 0; i < s.size(); i++) {
            int remainder = s.get(i) % k;

            if(remainders.containsKey(remainder)) {
                remainders.put(remainder, remainders.get(remainder) + 1);
                continue;
            }
            remainders.put(remainder, 1);
        }

        maxSubsetCount = Math.min(remainders.getOrDefault(0,0), 1);

        //Complementary remainders for

        for(int i = 1 ; i <= k/2; i++) {
            if(i != k - i) {
                int iRemainder = remainders.getOrDefault(i, 0);
                int kiRemainder = remainders.getOrDefault(k-i, 0);
                maxSubsetCount = maxSubsetCount + Math.max(iRemainder, kiRemainder);
            }
        }

        if(k%2==0) {
            int thereAre = remainders.getOrDefault(k/2, 0);
            if(thereAre != 0) {
                maxSubsetCount++;
            }
        }

        return maxSubsetCount;

    }

    public static void main(String[] args) {
        System.out.println(nonDivisibleSubset(4, Arrays.asList(5,7,6,4)));
    }

}
