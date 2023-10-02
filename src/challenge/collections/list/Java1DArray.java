package challenge.collections.list;

import java.util.Scanner;

public class Java1DArray {
    //4
    //00001101011101010101110
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int index = 0;
        int check = 0;
        while(check == 0){
            check = 1;
            if(index + 1 > game.length - 1 || index + leap > game.length - 1)
                return true;

            if  (game[index + leap] == 0) {
                index = index + leap;
                check = 0;
            }else if(game[index + 1] == 0){
                index = index + 1;
                check = 0;
            }else if ((index != 0) && (game[index - 1] == 0)) {
                game[index] = 1;
                index = index - 1;
                check = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] array = {0, 0, 1, 0, 0, 0};
        System.out.println(canWin(5, array));
    }

}
