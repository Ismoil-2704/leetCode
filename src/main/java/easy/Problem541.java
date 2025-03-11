package easy;

public class Problem541 {
    public static void main(String[] args) {
        System.out.println(reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39));
    }

    public static String reverseStr(String s, int k) {
        if (s.isEmpty() || s.length() < k) return new StringBuilder().append(s).reverse().toString();
        StringBuilder stringBuilder = new StringBuilder();
        int isReverse = k;
        for (int i = 0; i < s.length(); i++) {
            int rev = i + k;
            if (isReverse == k) {
                if (rev <= s.length())
                    stringBuilder.append(new StringBuilder(s.substring(i, rev)).reverse());
                else
                    stringBuilder.append(new StringBuilder(s.substring(i)).reverse());
                isReverse = 0;
                i = rev - 1;
            } else {
                stringBuilder.append(s.charAt(i));
                isReverse++;
            }
        }
        return stringBuilder.toString();
    }
}
