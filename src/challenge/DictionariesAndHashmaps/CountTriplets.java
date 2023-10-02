package challenge.DictionariesAndHashmaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long tripletsCount = 0;

        Map<Long, Long> multiples = new HashMap<>();

        long last = arr.get(0);
        long countIn = 1;
        multiples.putIfAbsent(last, 1L);

        for(int i = 1; i < arr.size(); i++){
            long a = arr.get(i); // 1
            if(last <= a) {
                multiples.putIfAbsent(a, 0L);
                multiples.put(a, multiples.get(a) + 1);

                if(countIn >= 3 && a != last){
                    long result = multiples.getOrDefault((last/(r*r)), 0L) *
                            multiples.getOrDefault((last/r), 0L) *
                            multiples.getOrDefault(last, 0L);
                    tripletsCount = tripletsCount + result;

                }
                countIn++;
                last = a;

            }

        }

        long result = multiples.getOrDefault((last/(r*r)), 0L) *
                multiples.getOrDefault((last/r), 0L) *
                multiples.getOrDefault(last, 0L);
        tripletsCount = tripletsCount + result;

        return tripletsCount;
    }


    public static void main(String[] args) {
        List<Long> list = Arrays.asList( 3L, 1L, 3L, 3L, 3L, 9L, 27L, 27L, 9L, 27L, 81L);
        System.out.println(countTriplets(list, 3));

    }
}
