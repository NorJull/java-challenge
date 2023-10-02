package challenge.stringManipulation;

public class AlternatingCharacters {

    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
        // Write your code here
        int min = 0;
        char currentChar = s.charAt(0);
        char nextChar = 0;
        for(int i = 1; i < s.length(); i++){
            nextChar = s.charAt(i);
            if(currentChar == nextChar){
                min++;
            } else {
                currentChar = nextChar;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "AAABBB";
        System.out.println(alternatingCharacters(s));
    }

}
