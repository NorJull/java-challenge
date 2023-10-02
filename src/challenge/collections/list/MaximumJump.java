package challenge.collections.list;


import java.util.Arrays;
import java.util.List;

public class MaximumJump {

    public static boolean canGetThere(List<Integer> jumps) {
        int position = jumps.size() - 1;

        for (int i = jumps.size() - 1; i >= 0; i--) {
            if (i + jumps.get(i) >= position) {
                position = i;
            }
        }
        return position == 0;
    }

    public static void main(String[] args) {

        System.out.println(canGetThere(Arrays.asList(2,3,1,1,4)));
        System.out.println(canGetThere(Arrays.asList(3,2,1,0,4)));
        System.out.println(canGetThere(Arrays.asList(3,2,3,0,4)));
    }
}
