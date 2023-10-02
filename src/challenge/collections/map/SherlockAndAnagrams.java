package challenge.collections.map;


import java.util.Arrays;
import java.util.HashMap;

public class SherlockAndAnagrams {
    /*Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
     Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
    * */

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba"));
    }
    public static int sherlockAndAnagrams(String s) {

        HashMap<String, Long> subStrings = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++) {
                // get substring from i to j and sort it
                String substring = s.substring(i, j);
                char chars[] = substring.toCharArray();
                Arrays.sort(chars);
                String stringSorted = new String(chars);

                Long value = subStrings.get(stringSorted);
                // add to the map
                if(value != null){
                    subStrings.put(stringSorted, value + 1);
                }else {
                    subStrings.put(stringSorted, 1L);
                }

            }
        }

        //(numRep * (numRep -1))/2

        return (int) subStrings.values().stream().mapToLong(val -> (val * (val -1))/2).sum();

    }
}
