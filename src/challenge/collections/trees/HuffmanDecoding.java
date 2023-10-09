package challenge.collections.trees;

public class HuffmanDecoding {
    class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;

    }

    void decode(String s, Node root) {

        StringBuilder stringBuilder = new StringBuilder();
        Node aux = root;
        for (int i = 0; i < s.length(); i++) {
            if(aux.left == null && aux.right == null) {
                stringBuilder.append(aux.data);
                aux = root;
            }

            if(s.charAt(i) == '1') {
                aux = aux.right;
            } else {
                aux = aux.left;
            }

        }

        System.out.println(stringBuilder.toString());
    }

}
