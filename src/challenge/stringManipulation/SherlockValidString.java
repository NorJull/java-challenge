package challenge.stringManipulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockValidString {

    public static String isValid(String s) {
        long diff = 0L;
        Map<Character, Long> sMap = s.chars()
                .mapToObj(x -> new Character((char) x))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Comparator<Long> comparator = (x, y) -> x.compareTo(y);
        Long mayor = sMap.values().stream().max(comparator).get();
        Long menor = sMap.values().stream().min(comparator).get();

        return mayor - menor >= 2 ? "NO" : "YES";
    }



    public static void main(String[] args) {
        String s = "aabbbccc";
        System.out.println(isValid(s));
    }
}
