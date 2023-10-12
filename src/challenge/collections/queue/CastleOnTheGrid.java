package challenge.collections.queue;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CastleOnTheGrid {

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER startX
     *  3. INTEGER startY
     *  4. INTEGER goalX
     *  5. INTEGER goalY
     */


    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) throws InterruptedException {
        // Add the whole grid into a grid[][]
        int size = grid.size();
        //   grid = ['.X.','.X.', '...']
        //  (x=0, y=2) -> string number 0, char number 1


        //Assuming that the starterPoint is always a (.): we start breadth first search
        /*
        the addd integers in the queue are in order
        the first one coming out is X and the second one Y
        *
         */
        //int predecessors[] = new int[size * size];
        Integer[] predecessors = new Integer[size * size];

        Queue<Integer> bfsQueue = new LinkedList<>();

        bfsQueue.add(startX);
        bfsQueue.add(startY);
        int x;
        int y;

        /*Color matrix
         * 0 -> Not visited
         * 2 -> In the queue
         * 3 -> Visited
         * */
        int colorMatrix[][] = new int[size][size];
        boolean valueFound = false;

        while (!bfsQueue.isEmpty() && !valueFound) {

            x = bfsQueue.poll();
            y = bfsQueue.poll();
            colorMatrix[x][y] = 3;

            // Can I move to the right?
            valueFound = moveRight(grid, goalX, goalY, size, predecessors, bfsQueue, x, y, colorMatrix, valueFound);


            // Can I move to the left?
            valueFound = moveLeft(grid, goalX, goalY, size, predecessors, bfsQueue, x, y, colorMatrix, valueFound);

            // Can I move down?
            valueFound = moveDown(grid, goalX, goalY, size, predecessors, bfsQueue, x, y, colorMatrix, valueFound);

            // Can I move up?
            valueFound = moveUp(grid, goalX, goalY, size, predecessors, bfsQueue, x, y, colorMatrix, valueFound);


        }
        valueFound = false;
        //  int startX, int startY, int goalX, int goalY

        int predecessorIndex = (startX * size) + startY;
        int currentNodeIndex = (goalX * size) + goalY;
        int count = 0;
        while (!valueFound) {
            currentNodeIndex = predecessors[currentNodeIndex];
            count++;
            if (predecessorIndex == currentNodeIndex)
                valueFound = true;
        }

        return count;
    }

    private static boolean moveRight(List<String> grid, int goalX, int goalY, int size, Integer[] predecessors, Queue<Integer> bfsQueue, int x, int y, int[][] colorMatrix, boolean valueFound) {
        for (int i = y + 1; i < size; i++) {
            char currentNode = grid.get(x).charAt(i);
            if (currentNode == 'X') {
                //get out of the for
                break;
            }
            //If the element haven't been visited
            if (colorMatrix[x][i] == 0) {
                //add this to the bfsQueue
                bfsQueue.add(x);
                bfsQueue.add(i);
                // change color  matrix
                colorMatrix[x][i] = 2;

                //save predecessors ???
                //   grid = ['.X.','.X.', '...']
                int predecessorIndex = (x * size) + y;
                int currentNodeIndex = (x * size) + i;
                predecessors[currentNodeIndex] = predecessorIndex;
            }
            if (x == goalX && i == goalY) {
                valueFound = true;
            }
        }
        return valueFound;
    }

    private static boolean moveLeft(List<String> grid, int goalX, int goalY, int size, Integer[] predecessors, Queue<Integer> bfsQueue, int x, int y, int[][] colorMatrix, boolean valueFound) {
        for (int i = y - 1; i >= 0; i--) {
            char currentNode = grid.get(x).charAt(i);
            if (grid.get(x).charAt(i) == 'X') {
                //get out of the for
                break;
            }
            //If the element haven't been visited
            if (colorMatrix[x][i] == 0) {
                //add this to the bfsQueue
                bfsQueue.add(x);
                bfsQueue.add(i);
                // change color  matrix
                colorMatrix[x][i] = 2;

                //save predecessors ???
                //   grid = ['.X.','.X.', '...']
                int predecessorIndex = (x * size) + y;
                int currentNodeIndex = (x * size) + i;
                predecessors[currentNodeIndex] = predecessorIndex;
            }

            if (x == goalX && i == goalY) {
                valueFound = true;
            }
        }
        return valueFound;
    }

    private static boolean moveDown(List<String> grid, int goalX, int goalY, int size, Integer[] predecessors, Queue<Integer> bfsQueue, int x, int y, int[][] colorMatrix, boolean valueFound) {
        for (int i = x + 1; i < size; i++) {
            char currentNode = grid.get(i).charAt(y);
            if (currentNode == 'X') {
                //get out of the for
                break;
            }
            //If the element haven't been visited
            if (colorMatrix[i][y] == 0) {
                //add this to the bfsQueue
                bfsQueue.add(i);
                bfsQueue.add(y);
                // change color  matrix
                colorMatrix[i][y] = 2;

                //save predecessors ???
                //   grid = ['.X.','.X.', '...']
                int predecessorIndex = (x * size) + y;
                int currentNodeIndex = (i * size) + y;
                predecessors[currentNodeIndex] = predecessorIndex;
            }
            if (i == goalX && y == goalY) {
                valueFound = true;
            }
        }
        return valueFound;
    }

    private static boolean moveUp(List<String> grid, int goalX, int goalY, int size, Integer[] predecessors, Queue<Integer> bfsQueue, int x, int y, int[][] colorMatrix, boolean valueFound) {
        for (int i = x - 1; i >= 0; i--) {
            char currentNode = grid.get(i).charAt(y);
            if (currentNode == 'X' || colorMatrix[i][y] != 0) {
                //get out of the for
                break;
            }
            //If the element haven't been visited
            //add this to the bfsQueue
            bfsQueue.add(i);
            bfsQueue.add(y);
            // change color  matrix
            colorMatrix[i][y] = 2;

            //save predecessors ???
            //   grid = ['.X.','.X.', '...']
            int predecessorIndex = (x * size) + y;
            int currentNodeIndex = (i * size) + y;
            predecessors[currentNodeIndex] = predecessorIndex;

            if (i == goalX && y == goalY) {
                valueFound = true;
            }
        }
        return valueFound;
    }

    public static void main(String[] args) throws InterruptedException {
        //   grid = ['.X.','.X.', '...']
        // .X.
        // .X.
        // ...
        List<String> grid = Arrays.asList("..X.", ".X..", "....", "....");
        int startX = 0, startY = 0, goalX = 0, goalY = 3;
       System.out.println( minimumMoves(grid, startX, startY, goalX, goalY));
    }
}
