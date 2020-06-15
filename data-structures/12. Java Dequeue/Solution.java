import java.util.*;

public class Solution {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt(), m = in.nextInt();
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt();
        }
        findUniqueIntegers(n, m, list);
        in.close();
    }

    private static void findUniqueIntegers(int n, int m, int[] list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++, m++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < m; j++) {
                set.add(list[j]);
            }
            if (max < set.size()) max = set.size();
            if (m == n) break;
        }
        System.out.print(max);
    }
}