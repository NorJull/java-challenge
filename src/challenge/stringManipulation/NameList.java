package challenge.stringManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameList {

    // Naren, Federico, Federico, Carlos, Naren
    /*

    Naren = 2
    Federico = 2
    Carlos = 1

    **/

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Naren", "Federico", "Federico", "Carlos", "Naren");

        //o(N)
        Map<String, Long> nameMaps =
                names.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // N log N
        List<String> winers = nameMaps.entrySet().stream()
                .sorted(Comparator.comparingLong((Map.Entry<String, Long> name) -> name.getValue())
                        .reversed()
                        .thenComparing((Map.Entry<String, Long> x) -> x.getKey())).limit(5)
                .map(name -> name.getKey()).  collect(Collectors.toList());

        System.out.println(winers);
    }


}
