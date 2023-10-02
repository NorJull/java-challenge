package challenge.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class minCM {

    static Boolean solution(int t, int[] input_arr) {
        // your code goes here
        for(int i=0; i< input_arr.length; i++){
            int aux = input_arr[i] ;
            for (int j = i+1; j < input_arr.length; j++) {
                aux = aux + input_arr[j];
                if(aux == t)
                     return true;
            }
        }
        return false;
    }


    //MAX Comun Divisor
    private static int maxCD(int first, int second){
        int maxCD = 0;

        int max = first > second ? first : second;
        int min = first > second ? second : first;

        do {
            maxCD = min;
            min = max%min;
            max = maxCD;
        }while (min != 0);
        return maxCD;
    }

    //MIN Comun multiplo

    private static int minCM(int first, int second){
        int minCM = 0;

        int max = first > second ? first : second;
        int min = first > second ? second : first;

        minCM = (max / maxCD(first, second))* min;
        return minCM;
    }

    private static int minCMTiempos(int[] input_arr){
        if(input_arr.length == 1)
            return input_arr[0];

        List<Integer> timesArray = new ArrayList();
        List<Integer> aux = new ArrayList<>();

        for (int i=0;i <input_arr.length; i++){
            timesArray.add(input_arr[i]);
        }


        while(timesArray.size() != 2){

            for (int i= 0; i < timesArray.size() -1; i++){
                int minCM = minCM(timesArray.get(i), timesArray.get(i+1));
                aux.add(minCM);
            }
            timesArray.clear();
            timesArray.addAll(aux);
            aux.clear();

        }


        return Collections.max(timesArray);
    }
    public static void main(String[] args) {
        int[] a = {1, 4, 7};
        a[0] = 1;
        a[1] = 2;
        System.out.println(solution(10, a));


    }
}
