package challenge.collections.list;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    /*
    * Add a new node to the end of the List
    * */
    public void append(T data){
        Node<T> node = new Node<>(data);

        if(this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }

        this.tail.next = node;
        this.tail = node;
    }


    /*
     * Add a new node to the beginning of the List
     * */
    public void prepend(T data){
        Node<T> node = new Node<>(data);

        if(this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }

        node.next = this.head;
        this.head = node;
    }

    public boolean delete(T data) {
        if (head == null) {
            return false;
        } else {

            Node current = this.head;
            //If the node to removed is the head
            if(current.data.equals(data)){
                //If head and tail are pointing to the same reference
                if(this.head == this.tail) {
                    this.head = null;
                    this.tail = null;
                    return true;
                }
                this.head = this.head.next;
                return true;
            }

            while(current.next != null) {
                if(current.next.data.equals(data)){
                    if(current.next == this.tail) {
                          this.tail = current;
                          current.next = null;
                    } else {
                        current.next = current.next.next;
                    }
                    return true;
                }
                current = current.next;
            }

        }

        return false;
    }

    @Override
    public String toString() {

        Node current = this.head;
        if( current == null)
            return "Null.";

        StringBuilder builder = new StringBuilder();
        builder.append(current.toString());

        while (current.next != null) {
            current = current.next;
            builder.append(", " + current.toString());
        }

        return builder.toString();
    }

    public class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
