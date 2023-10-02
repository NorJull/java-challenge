package challenge.collections.map;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TwoStrings {

    public static String twoStrings(String s1, String s2) {

        Map<Character, Character> characters = s1.chars().mapToObj(character -> new Character((char) character))
                .collect(Collectors.toMap(Function.identity(), Function.identity(), (x, y) -> x));

        for(int i = 0; i < s2.length(); i++){
            Character character = new Character(s2.charAt(i));
            if(characters.containsKey(character)){
                return "YES";
            }
        }

        return "NO";
        /*
        *         boolean match= s2.chars()
                .mapToObj(c -> new Character((char) c)).anyMatch(s -> letters.containsKey(s));
        return match ? "YES" : "NO";
        * */
    }

    public static void main(String[] args) {
        System.out.println(twoStrings("Naren", "ARE"));
    }
}
