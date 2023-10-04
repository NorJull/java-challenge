package challenge.collections.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackWithMinValue {


    List<Integer> elements;

    //Current minimum value 4
    List<Integer> minValues;


    public StackWithMinValue() {
        //Initialize the list
        this.elements = new ArrayList<>();
        this.minValues = new ArrayList<>();
    }

    public boolean push(Integer element) {
        if (element == null)
            return false;
        elements.add(element); //O(1)

        int lastIndex = minValues.size() - 1;

        if(lastIndex == - 1) {
            minValues.add(0);
        } else if (elements.get(minValues.get(lastIndex)) > element) {
            minValues.add(elements.size() -1);
        }
        return true;
    }

    public Integer pop() {
        if(elements.isEmpty()){
            throw new EmptyStackException();
        }
        int index = elements.size() - 1;
        Integer element = elements.get(index); //O(1)
        elements.remove(index);

        int lastIndex = minValues.size() - 1;

        if(index == minValues.get(lastIndex)){
            minValues.remove(lastIndex);
        }

        return element;
    }

    public Integer top() {
        if(elements.isEmpty()){
            throw new EmptyStackException();
        }

        int index = elements.size() - 1;
        return elements.get(index);  //O(1)
    }

    public Integer getMin(){
        if(elements.isEmpty())
            throw new EmptyStackException();

        int lastIndex = minValues.size() - 1;

        return elements.get(minValues.get(lastIndex));
    }
}
