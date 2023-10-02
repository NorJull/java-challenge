package challenge.DictionariesAndHashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockandAnagrams {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     *
     * k k k k
     *
     * k
     * k k
     * k k k
     * k k k k
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        int numberOfAnagrams = 0;
        Map<String, Integer> subStringMap = new HashMap();

        for (int i=0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                String subString = s.substring(i, j);

                char a[]=subString.toCharArray();

                Arrays.sort(a);

                subString =new String(a);

                if (subStringMap.containsKey(subString)){
                    subStringMap.put(subString, subStringMap.get(subString) + 1);
                }else {
                    subStringMap.put(subString, 1);
                }
            }
        }

        numberOfAnagrams = subStringMap.entrySet().stream().mapToInt(entry -> {
            if(entry.getValue() == 1)
                return 0;
            else
                return (entry.getValue() * (entry.getValue()-1))/2;

        }).sum();

        return  numberOfAnagrams;
    }

    public static void main(String[] args) {

//        System.out.println(sherlockAndAnagrams("dbcfibibcheigfccacfegicigcefieeeeegcghggdheichgafhdigffgifidfbeaccadabecbdcgieaffbigffcecahafcafhcdg"));

  "abda".chars().forEach(c -> {
      System.out.println(c);
  });

  System.out.println("Sum: "+"abda".chars().sum());
    }
}
