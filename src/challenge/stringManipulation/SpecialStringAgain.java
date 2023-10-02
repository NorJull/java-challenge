package challenge.stringManipulation;

public class SpecialStringAgain {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long count = 0;
        int index = 0;
        int subString = 0;

        boolean flat = false;
        char letter = s.charAt(0);
        char current = s.charAt(0);

        while(index < s.length()){
            current = s.charAt(index);
            count++;
            if(current == letter && flat == false) {
                subString++;
                if(subString > 1)
                    count++;
            }else if(current == letter && flat == true) {
                if(subString > 0){
                    count++;
                    subString--;
                }
            } else if (current != letter && s.charAt(index-1) == current){
                subString = 2;
                count++;
                letter = current;
                flat= !flat;
            }else if (current != letter){
                flat = !flat;
            }
            index++;
        }

        return count;
    }

    private static boolean isSpecial(StringBuilder subString) {

        return true;
    }

    public static void main(String[] args) {
        String special = "aaabaaa";
        System.out.println(substrCount(7, special));
    }
}
