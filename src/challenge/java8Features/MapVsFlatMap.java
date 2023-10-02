package challenge.java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapVsFlatMap {


    public static void main(String[] args) {

        // Map : map operation produces one output value for each input value

        List<String> names = Arrays.asList("Naren", "David", "De Avila", "Julio");

        names.stream().map(name -> name.toUpperCase()).forEach(System.out::println);

        //FlatMap : flatMap operation can produce zero or more values for each input value

        names.stream()
                .flatMap(name -> {
                    Stream<Character> characters = name.chars().mapToObj(letter -> new Character((char) letter));
                    return characters;
                }).forEach(System.out::println);

    }


}
