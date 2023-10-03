package challenge.collections.list;

public class LinkedListTester {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.append(12);
        list.append(10);
        list.append(15);

        list.prepend(5);

        list.delete(10);
        list.prepend(10);
        list.delete(12);
        list.delete(5);
        list.delete(15);
        list.delete(10);

        list.append(12);
        list.append(10);
        list.append(15);

        list.delete(12);
        list.delete(5);
        list.delete(15);
        list.delete(10);
        list.delete(5);
        list.delete(15);
        list.delete(10);

        list.prepend(10);
        System.out.println(list.toString());

    }
}
