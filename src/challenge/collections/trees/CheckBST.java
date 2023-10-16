package challenge.collections.trees;

public class CheckBST {


   static boolean checkBST(Node root) {

       return checkIfInRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean checkIfInRange(Node root, int min, int max) {
       if(root == null)
           return true;

       if(root.data < min)
           return false;

        if(root.data > max)
            return false;

        return checkIfInRange(root.left, min, root.data - 1) && checkIfInRange(root.right, root.data + 1, max );

    }

    static int maxValue(Node root) {
       if(root == null)
           return Integer.MIN_VALUE;

        int leftMaxValue = maxValue(root.left);
        int rightMaxValue = maxValue(root.right);

        return Math.max(Math.max(leftMaxValue, rightMaxValue), root.data);
    }

    static int minValue(Node root) {
        if(root == null)
            return Integer.MAX_VALUE;
        int leftMinValue = minValue(root.left);
        int rightMinValue = minValue(root.right);

        return Math.min(Math.min(leftMinValue, rightMinValue), root.data);
    }

   static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.right = new Node(2);
        tree.right.right = new Node(3);
        tree.right.right.right = new Node(4);
        tree.right.right.right.right = new Node(5);
        tree.right.right.right.right.right = new Node(6);
        tree.right.right.right.right.right.right = new Node(7);


        System.out.println(maxValue(tree.left));

        System.out.println(minValue(tree.right));

        System.out.println(checkBST(tree));
    }
}
