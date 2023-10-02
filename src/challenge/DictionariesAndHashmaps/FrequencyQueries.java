package challenge.DictionariesAndHashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FrequencyQueries {

    /*
    * -  : Insert x in your data structure.
-  : Delete one occurence of y from your data structure, if present.
-  : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.

    *
    * */

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> valueMap = new HashMap<>();


        for (int i = 0; i < queries.size(); i++) {
            Integer operation = queries.get(i).get(0);
            Integer value = queries.get(i).get(1);

            if (operation == 1) {
                valueMap.put(value, valueMap.getOrDefault(value, 0) + 1);
            } else if (operation == 2) {
                if (valueMap.containsKey(value) && valueMap.get(value) > 0)
                    valueMap.put(value, valueMap.get(value) - 1);
            } else {
                if (valueMap.containsValue(value))
                    result.add(1);
                else
                    result.add(0);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        /*
        *
        * 3 4
2 1003
1 16
3 1
        * */
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<100000; i++){
            List<Integer> aux = Arrays.asList((int) Math.random()*3+1, (int) Math.random()*20+1);
            list.add(aux);
        }
        System.out.println(list);
        System.out.println(freqQuery(list));
    }
}
