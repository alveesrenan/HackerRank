import java.util.HashMap;
import java.util.Scanner;

class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, String> phonebook = new HashMap<>();

        int n = in.nextInt();
        in.nextLine();

        while (n-- > 0) {
            phonebook.put(in.nextLine(), in.nextLine());
        }
        while (in.hasNext()) {
            String wanted = in.nextLine();
            if (!phonebook.containsKey(wanted)) {
                System.out.println("Not found");
                continue;
            }
            System.out.printf("%s=%s\n", wanted, phonebook.get(wanted));
        }
    }
}