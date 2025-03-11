package easy;

import java.util.HashMap;

public class Problem383 {
    public static void main(String[] args) {
        System.out.println(canConstructSolution2("Ismoil", "aabIiSsMmOoLlIs"));
    }

    public static boolean canConstructSolution1(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            hashtable.put(c, hashtable.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (hashtable.containsKey(c) && hashtable.get(c) >= 1)
                hashtable.put(c, hashtable.getOrDefault(c, 0) - 1);
            else
                return false;

        }
        return true;
    }

    public static boolean canConstructSolution2(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length())
            return false;
        int[] magCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            magCount[magazine.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if(magCount[c - 'a'] == 0)
                return false;
            magCount[c - 'a'] -= 1;
        }
        return true;
    }
}
