import java.util.LinkedList;
import java.util.Scanner;

public class BFSSearch {

    public static boolean search(Node node, int value) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr != null) {
                if (curr.value == value) return true;
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return false;
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
        System.out.printf("Value %s\n", BFSSearch.search(root, in.nextInt()) ? "found" : "not found");
    }
}