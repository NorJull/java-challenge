package challenge.implementation;

import java.math.BigInteger;

public class ExtraLongFactorial {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger factorial = BigInteger.valueOf(n);



        for(int i = 1; i < n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(n - i));
        }
        System.out.println(factorial.toString());
    }

    public static BigInteger extraLongFactorialsRecursive(BigInteger n) {
        // Write your code here
        if(n.equals(BigInteger.valueOf(1))) {
            return BigInteger.valueOf(1);
        }
        return n.multiply(extraLongFactorialsRecursive(n.subtract(BigInteger.valueOf(1))));
    }



    public static void main(String[] args) {
        System.out.println(extraLongFactorialsRecursive(BigInteger.valueOf(5)));
    }

}
