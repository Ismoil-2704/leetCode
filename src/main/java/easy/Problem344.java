package easy;

public class Problem344 {
    public static void main(String[] args) {
        char[] chars = {'H','a','n','n','a','h'};
        reverseString(chars);
        System.out.println(chars);
    }

    public static void reverseString(char[] s) {
        if (s == null || s.length == 0) return;

        for (int i = 0, j = s.length - 1; i < s.length / 2; i++, j--) {
            char first = s[i];
            char last = s[j];
            s[i] = last;
            s[j] = first;
        }
    }
}
