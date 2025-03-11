package easy;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Problem387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar1("aab"));
    }

    public static int firstUniqChar(String s) {
        if (s.length() == 1) return 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if (!map.containsValue(1)) return -1;

        for (Character c : map.keySet()) {
            if (map.get(c) == 1)
                return s.indexOf(c);
        }

        return -1;
    }

    public static int firstUniqChar1(String s) {
        int lengthed = s.length();
        if (lengthed == 1) return 0;

        boolean isUnique = true;
        for (int i = 0; i < lengthed; i++) {
            char c = s.charAt(i);
            for (int j = i + 1; j < lengthed; j++) {
                char c1 = s.charAt(j);
                if (c == c1) isUnique = false;
                if (isUnique && j == lengthed - 1) return i;
                if (!isUnique && j == lengthed - 1) isUnique = true;
            }
        }

        return -1;
    }
}
