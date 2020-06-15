import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt(), m = in.nextInt();
        BitSet[] bits = {new BitSet(n), new BitSet(n)};

        while (m-- > 0) {
            String operator = in.next();
            int x = in.nextInt(), y = in.nextInt();

            switch (operator) {
                case "AND":
                    bits[x - 1].and(bits[y - 1]);
                    break;
                case "OR":
                    bits[x - 1].or(bits[y - 1]);
                    break;
                case "XOR":
                    bits[x - 1].xor(bits[y - 1]);
                    break;
                case "FLIP":
                    bits[x - 1].flip(y);
                    break;
                case "SET":
                    bits[x - 1].set(y);
                    break;
                default:
                    break;
            }
            System.out.println(String.format("%d %d", bits[0].cardinality(), bits[1].cardinality()));
        }
    }
}
