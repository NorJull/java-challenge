package challenge.collections.trees;

public class TreesPlayGround {
    public static void main(String[] args) {
        Node tree = new Node(2);
        tree.insert(3);
        tree.insert(5);
        tree.insert(6);
        tree.insert(4);

        System.out.println(tree.contains(5));
        System.out.println(tree.contains(25));
        tree.printInOrder();
    }
}
