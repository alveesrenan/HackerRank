import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int n = in.nextInt();

        while (n-- > 0) {
            int d = in.nextInt();
            List<Integer> aux = new ArrayList<>(5);
            for (int j = 0; j < d; j++) {
                int value = in.nextInt();
                aux.add(value);
            }
            list.add(aux);
        }

        int q = in.nextInt();
        while (q-- > 0) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;

            if (list.get(x).isEmpty() || y >= list.get(x).size()) {
                System.out.println("ERROR!");
                continue;
            }
            System.out.println(list.get(x).get(y));
        }
    }
}