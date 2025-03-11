package easy;

import java.util.HashMap;

public class Problem242 {
    public static void main(String[] args) {
        String s = "rat", t = "car";

        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c1 = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
        }

        for (Character c : map.keySet()) {
            if (map1.containsKey(c)) {
                int i = map.get(c);
                int i1 = map1.get(c);
                if (i != i1)
                    return false;
            }else {
                return false;
            }
        }
        return true;
    }
}
