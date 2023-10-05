package challenge.arrayManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SparseArrays {

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Write your code here
       Map<String, Integer> results =  new HashMap<>();


        for (int i = 0; i < stringList.size(); i++) { // O(n)
            String  string = stringList.get(i);
            Integer result = results.get(string);
            if(result != null) {
                results.put(string, result + 1);
            } else {
                results.put(string, 1);
            }
        }

        return queries.stream().map(query -> {
            Integer value = results.get(query);
            return value == null ? 0 : value;
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String>  stringList = Arrays.asList("baba",
                "aba",
                "xzxb",
                "aba");

        List<String> queries = Arrays.asList("aba","xzxb","ab");

        System.out.println(matchingStrings(stringList, queries));
    }
}
