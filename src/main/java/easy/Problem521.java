package easy;

public class Problem521 {
    public static void main(String[] args) {
        System.out.println(findLUSlength("a","aaa"));
    }

    public static int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        boolean isEqualA = true;

        int cInt = -1;
        int lengthedA = a.length();
        for (int i = 0; i < lengthedA; i++) {
            int c = (int) a.charAt(i);
            if (cInt != -1 && c != cInt) isEqualA = false;
            cInt = c;
        }

        boolean isEqualB = true;
        int dInt = -1;
        int lengthedB = b.length();
        for (int i = 0; i < lengthedB; i++) {
            int c = (int) b.charAt(i);
            if (dInt != -1 && c != dInt) isEqualB = false;
            dInt = c;
        }

        if ((lengthedA == lengthedB) && isEqualA && isEqualB && cInt == dInt) return -1;

        return Math.max(lengthedA, lengthedB);

    }
}
