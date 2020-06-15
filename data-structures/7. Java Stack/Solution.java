import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNext()) {
            System.out.println(isStringBalanced(in.next()));
        }
        in.close();
    }

    private static boolean isStringBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        List<Character> openCharacters = Arrays.asList('{', '(', '[');
        List<Character> closeCharacters = Arrays.asList('}', ')', ']');

        if (input.length() % 2 != 0) return false;

        for (int i = 0; i < input.length(); i++) {
            char element = input.charAt(i);
            if (openCharacters.contains(element)) {
                stack.push(element);
                continue;
            }
            if (stack.isEmpty()) return false;

            char last = stack.pop();
            int i1 = openCharacters.indexOf(last);

            if (element != closeCharacters.get(i1)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}