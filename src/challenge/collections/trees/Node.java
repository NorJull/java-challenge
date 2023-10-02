package challenge.collections.trees;

public class Node {

    private int data;

    private Node left;

    private Node right;

    public Node(int data){
        this.data = data;
    }


    public void insert(int value) {
        if(value <= this.data) {
            if(this.left == null) {
                this.left = new Node(value);
            } else {
              this.left.insert(value);
            }
        } else {
            if(this.right == null) {
                this.right = new Node(value);
            } else {
                this.right.insert(value);
            }
        }
    }


    public boolean contains(int value) {
        if(this.data == value){
            return true;
        }
        if( value <= this.data) {
                if(this.left == null) {
                    return false;
                } else {
                    return this.left.contains(value);
                }
        } else {
            if(this.right == null) {
                return false;
            } else {
                return this.right.contains(value);
            }
        }
    }

    public void printInOrder() {
        if(this.left != null) {
            this.left.printInOrder();
        }
        System.out.println(this.data);
        if(this.right != null){
            this.right.printInOrder();
        }
    }


    public boolean delete(Node nodeToBeDeleted) {

        if( nodeToBeDeleted == null)
            return false;

        if(nodeToBeDeleted.getData() < this.data) {
            if(this.left == null) {
                return false;
            } else {
                this.left.delete(nodeToBeDeleted);
            }
        } else if (nodeToBeDeleted.getData() > this.data) {
            if(this.right == null) {
                return false;
            } else {
                this.right.delete(nodeToBeDeleted);
            }
        } else {

            //In case we find the node to be deleted in the tree
            //three things can occur

            //First scenario : Node does not have leaves
            if(this.right == null && this.left == null) {
                //this = null;
            }



        }


        return false;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
