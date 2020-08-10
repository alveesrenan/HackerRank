import java.util.Scanner;

public class LowestCommonAncestor {

    public static Node lowestCommonAncestor(Node node, int v1, int v2) {
        if (node == null) {
            return null;
        }

        if (v1 < node.value && v2 < node.value) return lowestCommonAncestor(node.left, v1, v2);
        if (v1 > node.value && v2 > node.value) return lowestCommonAncestor(node.right, v1, v2);

        return node;
    }
}

class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int n = in.nextInt();

        in.nextLine();
        while (n-- > 0) {
            tree.add(in.nextInt());
        }

        Node root = tree.getRoot();
        Node node = LowestCommonAncestor.lowestCommonAncestor(root, in.nextInt(), in.nextInt());
        System.out.println(String.format("Lowest common ancestor '%d'", node.value));
    }
}
