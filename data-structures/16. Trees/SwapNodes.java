import java.util.Scanner;

public class SwapNodes {

    private int[] tree;

    public SwapNodes(int n) {
        this.tree = new int[n];
    }

    private int left(int pos) {
        return (2 * pos) + 1;
    }

    private int right(int pos) {
        return (2 * pos) + 2;
    }

    private void swap(int x, int y) {
        int tmp = tree[x];
        tree[x] = tree[y];
        tree[y] = tmp;
    }

    private void heapify(int[][] indexes) {
        int i = 1, j = 0, n = indexes.length;

        tree[0] = 1;
        while (n-- > 0) {
            for (int k = 0; k < 2; k++, i++) {
                tree[i] = indexes[j][k];
            }
            j++;
        }
    }

    private int removeEmptyChildren(int pos) {
        int c = 0;
        for (int i = 0; i < pos; i++) {
            if (tree[i] == -1) c++;
        }
        return pos - c;
    }

    private void swapOperation(int level, int k, int pos, boolean[] visited) {
        pos = removeEmptyChildren(pos);
        if (!visited[pos]) {
            visited[pos] = true;

            if (level == k) {
                swap(left(pos), right(pos));
                return;
            }
        }
        int left = left(pos);
        int right = right(pos);

        if (left < tree.length - 1 && tree[left] != -1) swapOperation(level + 1, k, left, visited);
        if (right < tree.length - 1 && tree[right] != -1) swapOperation(level + 1, k, right, visited);
    }

    private void printInOrderTree(int pos, int n) {
        int rpos = removeEmptyChildren(pos);

        if (left(rpos) < n && tree[left(rpos)] != -1) printInOrderTree(left(rpos), n);
        System.out.printf("%d ", tree[pos]);
        if (right(rpos) < n && tree[right(rpos)] != -1) printInOrderTree(right(rpos), n);
    }

    public void swapNodes(int[][] indexes, int[] queries) {
        int n = queries.length;
        heapify(indexes);

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[tree.length];
            for (int j = i; j < n; j++) {
                swapOperation(1, queries[j], 0, visited);
            }
            printInOrderTree(0, tree.length - 1);
            System.out.println();
        }
    }
}

class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine().trim());
        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");
            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());
        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        SwapNodes tree = new SwapNodes(n * 2 + 1);
        tree.swapNodes(indexes, queries);
    }
}
