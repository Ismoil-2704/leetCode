public class Problem3146 {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "edbac";
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int indexT = t.indexOf(c);
            sum += Math.abs(i - indexT);
        }
        System.out.println(sum);
    }
}
