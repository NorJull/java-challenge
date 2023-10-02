package challenge.arrayManipulation;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


class Result {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation2(int n, List<List<Integer>> queries) {
        // Write your code h

        long[] array = new long[n];

        queries.forEach(query -> {
            Integer lastNumber = query.get(2);
            Integer leftIndex = query.get(0);
            Integer rightIndex = query.get(1);

            long sum = leftIndex + rightIndex;
            long div = sum / 2;

            if(sum % 2 !=0) {
                for (int i = 0;i + leftIndex <= div;i++) {
                    array[leftIndex - 1 + i] = array[leftIndex - 1 + i] + lastNumber;
                    array[rightIndex - 1 - i] = array[rightIndex - 1 - i] + lastNumber;
                }
            }else {

                array[(int) div - 1] = array[(int) div - 1] + lastNumber;

                for (int i = 0;i + leftIndex < div;i++) {
                    array[leftIndex - 1 + i] = array[leftIndex - 1 + i] + lastNumber;
                    array[rightIndex - 1 - i] = array[rightIndex - 1 - i] + lastNumber;
                }
            }

        });

        return Arrays.stream(array).max().getAsLong();
    }
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code h

        List<Long> arrayWithZeros = LongStream.of(new long[n])
                .boxed()
                .collect(Collectors.toList());


        queries.forEach(query -> {
            Integer lastNumber = query.get(2);
            Integer leftIndex = query.get(0);
            Integer rightIndex = query.get(1);

            sum(lastNumber, leftIndex, rightIndex, arrayWithZeros);


        });

        return Collections.max(arrayWithZeros);
    }

    private static void sum(Integer lastNumber,Integer leftIndex,Integer rightIndex, List<Long> arrayWithZeros) {

        long sum = leftIndex + rightIndex;
        long div = sum / 2;

        if(sum % 2 !=0) {
            for (int i = 0;i + leftIndex <= div;i++) {
                arrayWithZeros.set(leftIndex - 1 + i, arrayWithZeros.get(leftIndex - 1 + i) + lastNumber);
                arrayWithZeros.set(rightIndex - 1 - i, arrayWithZeros.get(rightIndex - 1 - i) + lastNumber);
            }
        }else {
            arrayWithZeros.set((int) div - 1, arrayWithZeros.get((int) div - 1) + lastNumber);

            for (int i = 0;i + leftIndex < div;i++) {
                arrayWithZeros.set(leftIndex - 1 + i, arrayWithZeros.get(leftIndex - 1 + i) + lastNumber);
                arrayWithZeros.set(rightIndex - 1 - i, arrayWithZeros.get(rightIndex - 1 - i) + lastNumber);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        List<Long> arrayWithZeros = LongStream.of(new long[9])
                .boxed()
                .collect(Collectors.toList());
        sum(100, 1, 7, arrayWithZeros);

    }

}
