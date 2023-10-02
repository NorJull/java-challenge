package challenge.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaArrayList {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
        * The first line has an integer n. In each of the next  n lines there will be an integer d denoting number of
        * integers on that line and then there will be d space-separated integers.
        * In the next line there will be an integer q  denoting number of queries. Each query will consist of two integers x and y.
        *
        *
        * */
        Scanner sc =new Scanner(System.in);

        int nLines = sc.hasNext() ? sc.nextInt() : -1;

        List<ArrayList> listOfList = new ArrayList<ArrayList>();
        //Read Lines
        if(nLines != -1){
            for (int i = 0; i < nLines; i++) {

                int dNumbers = sc.hasNext() ? sc.nextInt() : -1;
                ArrayList<Integer> newLine = new ArrayList<Integer>();
                if(dNumbers != -1)
                for(int  j = 0; j < dNumbers ; j ++){
                    newLine.add(sc.nextInt());
                }
                listOfList.add(newLine);
            }
        }

        //Read queries

        int nQueries = sc.hasNext() ? sc.nextInt() : -1;
        if(nQueries != -1){
            for (int i = 0; i < nQueries; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                if(x <= listOfList.size())
                    if(y <= listOfList.get(x - 1).size())
                        System.out.println(listOfList.get(x - 1).get(y - 1));
                    else
                        System.out.println("ERROR!");
            }
        }
    }

}
