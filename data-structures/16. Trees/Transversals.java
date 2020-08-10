import java.util.Scanner;

public class Transversals {

    public static void preOrder(Node node) {
        System.out.printf("%d ", node.data);
        if (node.left != null) preOrder(node.left);
        if (node.right != null) preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node.left != null) preOrder(node.left);
        System.out.printf("%d ", node.data);
        if (node.right != null) preOrder(node.right);
    }

    public static void posOrder(Node node) {
        if (node.left != null) preOrder(node.left);
        if (node.right != null) preOrder(node.right);
        System.out.printf("%d ", node.data);
    }
}

class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(Stirng[] args) {
        int n = in.nextInt();
        BinaryTree tree = new BinaryTree();

        in.nextLine();
        while (n-- > 0) {
            tree.add(in.nextInt());
        }

        Node root = tree.root;
        Transversals.preOrder(root);
    }
}