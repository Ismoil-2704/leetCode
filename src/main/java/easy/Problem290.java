package easy;

import java.util.HashMap;
import java.util.Objects;

public class Problem290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> bijections = new HashMap<>();

        String[] splitWords = s.split(" ");

        if (pattern.length() != splitWords.length) return false;

        for (int i = 0; i < splitWords.length; i++) {
            String word = splitWords[i];
            char letter = pattern.charAt(i);

            if (bijections.containsValue(word) && !bijections.containsKey(letter)) return false;
            if (!bijections.containsKey(letter)) bijections.put(letter, word);
            if (!Objects.equals(bijections.get(letter), word)) return false;
        }
        return true;
    }
}
