import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.HashMap;

class Trie {
    private HashMap<Character, Trie> children = new HashMap<>();
    private boolean isEndOfWord;

    public HashMap<Character, Trie> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}

public class Contacts {

    private static Trie root = new Trie();
    private static String words = "";

    public static void main(String[] args) {
        String[][] input = {
                {"add", "tree"},
                {"add", "trie"},
                {"add", "algo"},
                {"find", "algo"},
                {"find", "tr"}
        };
        int[] contacts = contacts(input);
        for (int contact : contacts) {
            System.out.println(contact);
        }
    }

    private static void addWord(String word) {
        Trie node = root;
        words += word;

        for (char key : word.toCharArray()) {
            node = node.getChildren().computeIfAbsent(key, character -> new Trie());
        }
        node.setEndOfWord(true);
    }

    private static boolean containsString(String word) {
        Trie node = root;
        for (char key : word.toCharArray()) {
            Trie current = node.getChildren().get(key);
            if (current == null) {
                return false;
            }
            node = current;
        }
        return node.isEndOfWord();
    }

    private static int findPartial(String word) {
        Trie node = root;
        for (char key : word.toCharArray()) {
            Trie current = node.getChildren().get(key);
            if (current == null) {
                return 0;
            }
            node = current;
        }
        return (node.getChildren() != null) ? countEndOfWordsOnTrie(node, 0) : 0;
    }

    private static int countEndOfWordsOnTrie(Trie node, int occurrences) {
        Stack<Trie> stack = new Stack<>();
        stack.add(node);

        while (!stack.isEmpty()) {
            Trie current = stack.pop();

            if (current.isEndOfWord()) occurrences++;
            if (current.getChildren() != null) {
                stack.addAll(current.getChildren().values());
            }
        }
        return occurrences;
    }

    private static int[] contacts(String[][] queries) {
        List<Integer> result = new ArrayList<>(queries.length);
        for (String[] query : queries) {
            String word = query[1];
            switch (query[0]) {
                case "add":
                    addWord(word);
                    break;
                case "find":
                    result.add(findPartial(word));
                    break;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
