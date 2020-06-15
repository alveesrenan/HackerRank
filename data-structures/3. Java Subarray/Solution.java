import java.util.Scanner;

public class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt(), count = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += arr[k];
                }
                if (sum < 0) count++;
            }
        }
        System.out.println(count);
    }
}