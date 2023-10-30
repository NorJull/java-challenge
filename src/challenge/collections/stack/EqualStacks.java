package challenge.collections.stack;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class EqualStacks {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        int maxHeight = 0;
        int h1Index = 0;
        int sumH1 = h1.stream().mapToInt(x -> x).sum();
        int h2Index =  0;
        int sumH2 = h2.stream().mapToInt(x -> x).sum();
        int h3Index =  0;
        int sumH3 = h3.stream().mapToInt(x -> x).sum();

        if(h1.isEmpty() || h2.isEmpty() || h3.isEmpty())
            return 0;

        while(true) {
            int minSum = Math.min(sumH1, Math.min(sumH2, sumH3));

            while(sumH1 > minSum && h1Index < h1.size())  {
                sumH1 = sumH1 - h1.get(h1Index);
                h1Index++;
            }

            while(sumH2 > minSum && h2Index < h2.size())  {
                sumH2 = sumH2 - h2.get(h2Index);
                h2Index++;
            }

            while(sumH3 > minSum && h3Index < h3.size())  {
                sumH3 = sumH3 - h3.get(h3Index);
                h3Index++;
            }

            if(sumH1 == sumH2 && sumH2 == sumH3)
                return sumH1;
        }

    }

    public static void main(String[] args) {

        List<Integer> h1 = Arrays.asList(3, 2, 1, 1, 1);
        List<Integer> h2 = Arrays.asList(4, 3, 2);
        List<Integer> h3 = Arrays.asList(1, 1, 4, 1);

        System.out.println(equalStacks(h1, h2, h3));

    }
}
