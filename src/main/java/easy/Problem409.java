package easy;

import java.util.HashMap;

public class Problem409 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        boolean wasOdd = false;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for (Character c : map.keySet()) {
            Integer i = map.get(c);
            if (i % 2 == 0) {
                max += i;
            }else {
                wasOdd = true;
                max += i - 1;
            }
        }
        if (wasOdd) max++;
        return max;
    }
}
