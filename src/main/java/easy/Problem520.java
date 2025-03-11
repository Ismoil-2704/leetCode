package easy;

import java.util.Locale;

public class Problem520 {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse2("Fla"));
    }

    public static boolean detectCapitalUse(String word) {
        if (word.isEmpty()) return false;
        String lowerCase = word.toLowerCase();
        if (word.toUpperCase().equals(word)) return true;
        if (lowerCase.equals(word)) return true;

        if (Character.isUpperCase(word.charAt(0))){
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i)))
                    return false;
            }
            return true;
        }
        return false;
    }

    public static boolean detectCapitalUse2(String word) {
        if (word.isEmpty()) return false;
        int lengthed = word.length();
        int smallLatter = 0;
        for (int i = 0; i < lengthed; i++) {
            if (word.charAt(i) < 'a') {
                smallLatter++;
            }
        }
        if (smallLatter == lengthed || smallLatter == 0) {
            return true;
        }
        if (smallLatter == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        return false;
    }
}
