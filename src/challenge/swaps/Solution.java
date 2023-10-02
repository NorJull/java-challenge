package challenge.swaps;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int aux = 0;
        int aux2 = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != i+1) {
                aux =  arr[i];
                aux2 = arr[aux-1];
                arr[i] = aux2;
                arr[aux-1] = aux;
                i--;
                swaps++;
            }
        }

        return swaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] arr = new int[] {4, 3, 1, 2};

        System.out.println(minimumSwaps(arr));

    }
}
