package challenge.stringManipulation;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MakingAnagrams {

    public static int makeAnagram(String a, String b) {
        int  count = 0;

        Map<Character, Long> aMap = a.chars()
                .mapToObj(x -> new Character((char) x))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> bMap = b.chars()
                .mapToObj(x -> new Character((char) x))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(Map.Entry<Character, Long> entry : aMap.entrySet()){
            int aValue = entry.getValue().intValue();
            int bValue = bMap.getOrDefault(entry.getKey(), 0L).intValue();
            count = count + Math.abs(aValue - bValue);
            bMap.remove(entry.getKey());
        }

        for(Map.Entry<Character, Long> entry : bMap.entrySet()){
            int aValue = entry.getValue().intValue();
            int bValue = aMap.getOrDefault(entry.getKey(), 0L).intValue();
            count = count + Math.abs(aValue - bValue);
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println( makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }
}
