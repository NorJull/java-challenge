package challenge.collections.map;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNotes {

    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Long> magazineWords =
                magazine.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting()));


        for(int i = 0; i < note.size(); i++) {
            //         for(int i = 0; i < note.size(); i++){
            //             Long number = map.get(note.get(i));
            String word = note.get(i);
            Long value = magazineWords.get(word);
            if(value == null || value == 0){
                System.out.println("No");
                return;
            } else {
                magazineWords.put(word, value-1);
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {

    }
}
