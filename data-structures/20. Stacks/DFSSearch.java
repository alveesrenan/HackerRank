import java.util.Scanner;

public class DFSSearch {

    public static boolean found;

    public static boolean search(Node root, int value) {
        if (root == null) throw new IllegalArgumentException("Binary tree is empty!");
        dfs(root, value);
        return found;
    }

    public static void dfs(Node node, int value) {
        if (node != null && !node.visited) {
            node.visited = true;

            if (node.value == value) found = true;
            dfs(node.left, value);
            dfs(node.right, value);
        }
    }
}

class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        BinaryTree tree = new BinaryTree();

        in.nextLine();
        while (n-- > 0) {
            tree.add(in.nextInt());
        }

        Node root = tree.root;
        System.out.printf("Value %s\n", DFSSearch.search(root, in.nextInt()) ? "found" : "not found");
    }
}