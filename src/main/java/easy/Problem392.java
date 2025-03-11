package easy;

public class Problem392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;

        int lastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastIndex < t.length()) {
                for (int i1 = lastIndex; i1 < t.length(); i1++) {
                    char c1 = t.charAt(i1);
                    if (c == c1) {
                        lastIndex = i1 + 1;
                        break;
                    }
                    if (i1 == t.length() - 1) {
                        return false;
                    }
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
