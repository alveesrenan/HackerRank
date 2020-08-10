class Node {
    int value;
    Node left;
    Node right;
    boolean visited;

    public Node(int value) {
        this.value = value;
    }
}

public class BinaryTree {

    Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        add(root, value);
    }

    private Node add(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value > node.value) node.right = add(node.right, value);
        else if (value < node.value) node.left = add(node.left, value);

        return node;
    }
}