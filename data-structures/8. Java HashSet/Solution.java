import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        int count = 0;
        HashSet<String> set = new HashSet<>();
        while (count < t) {
            String string = pair_left[count].concat(" ").concat(pair_right[count]);
            set.add(string);
            System.out.println(set.size());
            count += 1;
        }
    }
}
