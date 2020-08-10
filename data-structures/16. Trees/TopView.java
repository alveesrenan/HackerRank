import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Pair<U, V> {
    U first;
    V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    static <U, V> Pair<U, V> of(U u, V v) {
        return new Pair<>(u, v);
    }
}

public class TopView {

    private static Map<Integer, Pair<Integer, Integer>> topview = new TreeMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        int n = in.nextInt();

        in.nextLine();
        while (n-- > 0) {
            tree.add(in.nextInt());
        }

        Node root = tree.getRoot();
        topViewOfTree(root, 0, 0);
        topview.values().forEach(pair -> System.out.printf("%d ", pair.first));
    }

    private static void topViewOfTree(Node node, int dist, int height) {
        if (node == null) {
            return;
        }

        if (!topview.containsKey(dist) || topview.get(dist).second > height) {
            topview.put(dist, Pair.of(node.value, height));
        }

        topViewOfTree(node.left, dist - 1, height + 1);
        topViewOfTree(node.right, dist + 1, height + 1);
    }
}
