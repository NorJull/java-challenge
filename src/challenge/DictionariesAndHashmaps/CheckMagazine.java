package challenge.DictionariesAndHashmaps;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckMagazine {
    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        //int noContain = 0;-
        Map<String, Long> map =
                magazine.stream().collect(Collectors.groupingBy(string -> string , Collectors.counting()));

         for(int i = 0; i < note.size(); i++){
             Long number = map.get(note.get(i));
             if(number == null || number == 0){
                 System.out.println("No");
                 return;
             }
             map.put(note.get(i), number-1);
         }
        System.out.println("Yes");

    }

    public static void main(String[] args) {
        //give one grand today
        List<String> magazine = Arrays.asList("give", "me", "one", "today", "night","grand");

        List<String> note = Arrays.asList("give", "one", "grand", "today");
        checkMagazine(magazine, note);
    }
}
