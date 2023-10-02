package challenge.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FraudulentActivityNotifications {

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        int result = 0;
        int takeOut = 0;
        Integer takeOutValue = 0;
        Double median = 0d;
        List<Integer> orderedList = new LinkedList<>(expenditure.subList(0, d));
        Collections.sort(orderedList);

        for (int i = d; i < expenditure.size(); i++) {

            median = getMedian(orderedList);


            if(expenditure.get(i) >= median*2){
                result ++;
            }

            takeOutValue = expenditure.get(takeOut);

            //Take out this value from the ordered list.
            orderedList.remove(takeOutValue);

            addToOrderedList(orderedList, expenditure.get(i), median);

            takeOut++;
        }


        return result;
    }

    private static void addToOrderedList(List<Integer> orderedList, Integer value, Double median) {
        if(value >= orderedList.get(orderedList.size()-1)){
            orderedList.add(orderedList.size(), value);
            return;
        }

        if(value < median){
            for(int i = 0; i < median; i++){
                if(orderedList.get(i) > value){
                    orderedList.add(i, value);
                    break;
                }
            }
        } else {
            for(int i = median.intValue(); i < orderedList.size(); i++){
                if(orderedList.get(i) > value){
                    orderedList.add(i, value);
                    break;
                }
            }

        }

    }
    private static Double getMedian(List<Integer> orderedList) {
        int size = orderedList.size();
        int mitad = size / 2;

        if (size % 2 == 0) {
            Double fisrt = Double.valueOf(orderedList.get(mitad- 1));
            Double second = Double.valueOf(orderedList.get(mitad));

            return (fisrt +  second)/2;
        } else {
            return (double) orderedList.get(mitad);
        }
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5);
        System.out.println(activityNotifications(list, 5));
    }
}
