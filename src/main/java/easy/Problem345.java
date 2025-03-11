package easy;

public class Problem345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("AceCreIm"));
    }

    public static String reverseVowels(String s) {
        if (s.isEmpty() || s.length() == 1)
            return s;

        char[] characters = s.toCharArray();
        String vowels = "aeiouAEIOU";

        int firstExist = -1;
        int lastExist = -1;
        int length = s.length() - 1;

        int i = 0;
        int j = length;
        while (i <= length / 2 || j >= length / 2) {
            if (i > length || j < 0)
                break;

            char first = s.charAt(i);
            char last = s.charAt(j);
            if (vowels.indexOf(first) == -1) {
                characters[i] = first;
                i++;
            } else {
                firstExist = i;
            }
            if (vowels.indexOf(last) == -1) {
                characters[j] = last;
                j--;
            } else {
                lastExist = j;
            }

            if (firstExist != -1 && lastExist != -1) {
                characters[i] = last;
                characters[j] = first;
                firstExist = -1;
                lastExist = -1;
                i++;
                j--;
            }
        }
        return new String(characters);
    }
}
