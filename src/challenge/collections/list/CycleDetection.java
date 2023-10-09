package challenge.collections.list;

public class CycleDetection {
    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode slowPointer = head;
        SinglyLinkedListNode fastPointer = head;

        while(fastPointer.next != null && fastPointer.next.next != null ){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer)
                return true;
        }
        return false;
    }
}

class   SinglyLinkedListNode {
                  int data;
                  SinglyLinkedListNode next;
}