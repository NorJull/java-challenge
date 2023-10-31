package challenge.collections.stack;

import java.util.Scanner;
import java.util.Stack;

/*S: Current string
* 1. append(W) - Append string W  to the end of S.
  2. delete(k) - Delete the last k characters of S.
  3. print(k) - Print the k character of S.
  4. undo - Undo the last (not previously undone) operation of type 1 or 2 ,
   * reverting S  to the state it was in prior to that operation.
* */
public class SimpleTextEditor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        // Create a Scanner object to read from STDIN
        Scanner scanner = new Scanner(System.in);

        //Number of operations
        int qInteger = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();

        //Stack of last 1 or 2 operations
        Stack<String> lastOperations = new Stack<>();


        for(int i = 0; i < qInteger; i++) {
            int typeOfOperation = scanner.nextInt();
            //Append Operation
            if(typeOfOperation == 1) {
                String argument = scanner.next();
                stringBuilder.append(argument);
                lastOperations.push(1+argument);
            } else if (typeOfOperation == 2) {
                int argument = scanner.nextInt();
                int length = stringBuilder.length();
                String stringTobeDeleted = stringBuilder.substring(length - argument, length);
                lastOperations.push(2+stringTobeDeleted);
                stringBuilder.delete(length - argument, length);
            } else if (typeOfOperation == 3) {
                int argument = scanner.nextInt();
                System.out.println(stringBuilder.charAt(argument - 1));
            } else {
              String  lastOperation = lastOperations.pop();
              char type = lastOperation.charAt(0);
              if(type == '1') {
                  int length = stringBuilder.length();
                  stringBuilder.delete(length - (lastOperation.length() - 1), length);
              } else {
                  stringBuilder.append(lastOperation.substring(1));
              }
            }
        }



    }

}
