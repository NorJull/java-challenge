package challenge.sorting;

import java.util.List;

public class BubbleSort {

    public static void countSwaps(List<Integer> a) {
        // Write your code here
        Integer aux = 0;
        int swaps = 0;
        int size = a.size();
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a.get(j) > a.get(j+1)) {
                    aux = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j + 1, aux);
                    swaps++;
                }
            }

        }

        System.out.println("Array is sorted in "+ swaps +" swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(size-1));
    }

}
