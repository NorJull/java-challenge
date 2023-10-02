package challenge.java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsTests {
    public static void main(String[] args) {

        // toMap
        List<String> names = Arrays.asList("Naren", "David", "De Avila", "Julio");

        Map<String, Integer> result = names.stream().collect(Collectors.toMap(Function.identity(), name -> name.length()));

        result.forEach((key, value) -> System.out.println(value));
        //If there are duplicates keys we will get an IllegalStateException to try that we need to solve collitions

        result = names
                .stream()
                .collect(Collectors.toMap(Function.identity(), name -> name.length(), (value1, value2) -> value1));
        result.forEach((key, value) -> System.out.println(key));
    }
}
