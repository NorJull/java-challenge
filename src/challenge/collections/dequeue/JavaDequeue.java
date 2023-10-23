package challenge.collections.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class JavaDequeue {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int[] dpArray = new int[10000000];

        int countDiff = 0;

        for (int i = 1; i <= m; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            if(dpArray[num] == 0) {
                countDiff++;
            }
            dpArray[num] = dpArray[num] + 1;
        }

        int numDiff = countDiff;

        for(int i = 1; i <= (n-m); i++) {
            Integer exHead = deque.pollFirst();

            if(dpArray[exHead] == 1) {
                numDiff--;
            }

            dpArray[exHead] = dpArray[exHead] - 1;

            int num = in.nextInt();
            deque.addLast(num);

            if(dpArray[num] == 0) {
                numDiff++;
            }

            dpArray[num] = dpArray[num] + 1;

            if(numDiff > countDiff) {
                countDiff = numDiff;
                if(countDiff == m) {
                    break;
                }
            }
        }

        System.out.println(countDiff);

    }

}
