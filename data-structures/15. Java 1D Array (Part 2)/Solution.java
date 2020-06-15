import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static boolean canWin(int leap, int[] game) {
        boolean win = false;
        int position = 0, length = game.length;

        if (!notContainsOnlyZeros(game)) return true;

        for (int i = 0; i < length; i++) {
            if (position == length - 1 || position + leap > length - 1) {
                win = true;
                break;
            }

            game[position] = 1;
            if (game[position + 1] == 0) {
                if (position + 1 == length - 1) {
                    win = true;
                    break;
                }
                position += 1;
            } else if (game[position + leap] == 0) {
                position += leap;
            } else {
                position = findPreviousAllowedPosition(position, game);
            }
        }
        return win;
    }

    private static int findPreviousAllowedPosition(int position, int[] game) {
        int found = position;
        for (int i = position; i >= 0; i--) {
            if (game[i] == 0) {
                found = i;
                break;
            }
        }
        return found;
    }

    private static boolean notContainsOnlyZeros(int[] game) {
        return Arrays.stream(game)
                .filter(value -> value != 0)
                .findFirst()
                .isPresent();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
