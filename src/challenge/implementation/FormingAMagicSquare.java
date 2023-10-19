package challenge.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormingAMagicSquare {

    /*
    *     magic_squares = [
        [ [8, 1, 6],
        * [3, 5, 7],
        * [4, 9, 2]],

        * [
        * [6, 1, 8],
        * [7, 5, 3],
        * [2, 9, 4]],
        [
        * [4, 9, 2],
        * [3, 5, 7],
        * [8, 1, 6]],
        [
        * [2, 9, 4],
        * [7, 5, 3],
        * [6, 1, 8]],
        [
        * [8, 3, 4],
        * [1, 5, 9],
        * [6, 7, 2]],
        [
        * [4, 3, 8],
        * [9, 5, 1],
        * [2, 7, 6]],
        [
        * [6, 7, 2],
        * [1, 5, 9],
        * [8, 3, 4]],
        [
        * [2, 7, 6],
        * [9, 5, 1],
        * [4, 3, 8]]
    ]
    * */


    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        List<List<Integer>> s1 = Arrays.asList(Arrays.asList(8, 1, 6), Arrays.asList(3, 5, 7), Arrays.asList(4, 9, 2));
        List<List<Integer>> s2 = Arrays.asList(Arrays.asList(6, 1, 8), Arrays.asList(7, 5, 3), Arrays.asList(2, 9, 4));
        List<List<Integer>> s3 = Arrays.asList(Arrays.asList(4, 9, 2), Arrays.asList(3, 5, 7), Arrays.asList(8, 1, 6));
        List<List<Integer>> s4 = Arrays.asList(Arrays.asList(2, 9, 4), Arrays.asList(7, 5, 3), Arrays.asList(6, 1, 8));
        List<List<Integer>> s5 = Arrays.asList(Arrays.asList(8, 3, 4), Arrays.asList(1, 5, 9), Arrays.asList(6, 7, 2));
        List<List<Integer>> s6 = Arrays.asList(Arrays.asList(4, 3, 8), Arrays.asList(9, 5, 1), Arrays.asList(2, 7, 6));
        List<List<Integer>> s7 = Arrays.asList(Arrays.asList(6, 7, 2), Arrays.asList(1, 5, 9), Arrays.asList(8, 3, 4));
        List<List<Integer>> s8 = Arrays.asList(Arrays.asList(2, 7, 6), Arrays.asList(9, 5, 1), Arrays.asList(4, 3, 8));

        List<List<List<Integer>>> solutions = new ArrayList<>();
        solutions.add(s1);
        solutions.add(s2);
        solutions.add(s3);
        solutions.add(s4);
        solutions.add(s5);
        solutions.add(s6);
        solutions.add(s7);
        solutions.add(s8);

        int minCost = Integer.MAX_VALUE;

        for (List<List<Integer>> solution : solutions){
            int sum = 0;
             for(int i = 0; i < 3; i++) {
                 sum = sum + Math.abs(solution.get(0).get(i) - s.get(0).get(i)) +
                             Math.abs(solution.get(1).get(i) - s.get(1).get(i)) +
                             Math.abs(solution.get(2).get(i) - s.get(2).get(i));

             }
             if(sum < minCost)
                 minCost = sum;
        }

        return minCost;

        /*
        * return solutions.stream()
            .mapToInt(solution -> IntStream.range(0, 3)
                    .map(i -> IntStream.range(0, 3)
                            .map(j -> Math.abs(solution.get(i).get(j) - s.get(i).get(j))
                            ).sum()
                    ).sum()
            )
            .min()
            .orElse(Integer.MAX_VALUE);
        * */
    }

    public static void main(String[] args) {
        List<List<Integer>> s8 = Arrays.asList(Arrays.asList(2, 7, 6), Arrays.asList(9, 5, 1), Arrays.asList(4, 3, 7));
        System.out.println(formingMagicSquare(s8));
    }
}
