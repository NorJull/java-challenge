package challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Tests {

    public static void main(String[] args) {


        List<String> coLazyGroup = Arrays.asList("Naren", "Raul", "Juanjo", "Toreto", "Dwan");



        Map<Character, Long> result = coLazyGroup.stream().flatMap(word -> {
            Stream<Character> characters = word.chars().mapToObj(letter -> new Character((char) letter));
            return characters;

        }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        Character character = result
                .entrySet().stream()
                .max((c1, c2) -> c1.getValue() > c2.getValue() ? 1 : -1).get().getKey();


        System.out.println(character);


        String word = "lateleletal";

        int wordLength = word.length();
        boolean flat = IntStream.range(0, wordLength / 2).boxed()
                .anyMatch(i -> word.charAt(i) != word.charAt(wordLength - 1 - i));

        if(flat) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
