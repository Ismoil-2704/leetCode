import java.util.*;

public class Problem17 {
    public static void main(String[] args) {
        String digits = "234";

        HashMap<Integer, String> numLet = new HashMap<>();
        numLet.put(2, "abc");
        numLet.put(3, "def");
        numLet.put(4, "ghi");
        numLet.put(5, "jkl");
        numLet.put(6, "mno");
        numLet.put(7, "pqrs");
        numLet.put(8, "tuv");
        numLet.put(9, "wxyz");

        List<String> letters = new ArrayList<>();
        letters.add("");
        int s = 0, e = 1;
        for (int i = 0; i < digits.length(); i++, s = e) {
            String list = numLet.get(digits.charAt(i) - '0');
            e = letters.size();
            for (int j = 0; j < list.length(); j++) {
                char sChar = list.charAt(j);
                for (int k = s; k < e; k++) {
                    letters.add(letters.get(k) + sChar);
                }
            }
        }
        System.out.println(letters.subList(e, letters.size()));
    }
}
