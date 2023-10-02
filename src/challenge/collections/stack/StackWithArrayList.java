package challenge.collections.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StackWithArrayList {

    private List<Integer> myStack;

    public StackWithArrayList(){
        this.myStack = new ArrayList<>();
    }

    /*
    * push: Add a new element to the stack
    *
    * */

    public boolean push(Integer element) {
        if(element == null)
            return false;

        myStack.add(element);
        return true;
    }


    /*
    * pop: Return the last inserted element, and deleted from the top.
    *
    * */
    public Integer pop() {
        if(isEmpty())
            throw new NoSuchElementException("Empty Stack");
        Integer myElement = myStack.get(myStack.size() - 1);
        myStack.remove(myStack.size() - 1);
        return myElement;
    }

    /*
     * peek: Return the last inserted element
     *
     * */
    public Integer peek() {
        if(isEmpty())
            throw new NoSuchElementException("Empty Stack");

        return myStack.get(myStack.size() - 1);
    }




    /*
    * isEmpty: return if the stack is empty
    * */
    public boolean isEmpty() {
        return myStack.isEmpty();
    }

    @Override
    public String toString() {
        return "StackWithArrayList{" +
                "myStack=" + myStack +
                '}';
    }
}
