package easy;

import java.util.Arrays;

public class Problem205 {
    public static void main(String[] args) {
        String s = "bbbaaaba";
        String t = "aaabbbba";

        if (s.length() != t.length())
            System.out.println(false);


        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        int sumS = 0;
        int sumT = 0;
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            String c2 = String.valueOf(t.charAt(i));

            if (s1.toString().contains(c) && !s2.toString().contains(c2) ||
                    !s1.toString().contains(c) && s2.toString().contains(c2) ||
                    sumS != sumT) {
                System.out.println(false);
                break;
            }

            s1.append(c);
            s2.append(c2);

            sumS++;
            sumT++;
        }
        System.out.println(sumS);
        System.out.println(sumT);
    }
}
