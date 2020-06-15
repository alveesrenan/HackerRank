import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Operation {
    Insert, Delete;
}

public class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        int q = in.nextInt();
        while (q-- > 0) {
            String op = in.next();

            if (op.equals(Operation.Insert.name())) {
                add(in.nextInt(), in.nextInt(), list);
                continue;
            }
            remove(in.nextInt(), list);
        }
        list.forEach(value -> System.out.printf("%d ", value));
    }

    private static void add(int index, int value, List<Integer> list) {
        if (index > list.size() - 1) {
            list.add(value);
            return;
        }
        list.add(index, value);
    }

    private static void remove(int index, List<Integer> list) {
        list.remove(index);
    }
}