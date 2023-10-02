package challenge.DictionariesAndHashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TwoString {
    public static String twoStrings(String s1, String s2) {

        Map<Character, Character> letters =
                s1.chars()
                        .mapToObj(c -> new Character((char) c)).distinct()
                        .collect(Collectors.toMap(Function.identity(), Function.identity()));

        boolean match= s2.chars()
                .mapToObj(c -> new Character((char) c))
                .anyMatch(s -> letters.containsKey(s));

        return match ? "YES" : "NO";

    }

    public static void main(String[] args) {
        String s1 = "Nassss";
        String s2 = "nk";
        System.out.println(twoStrings(s1, s2));
    }

}
