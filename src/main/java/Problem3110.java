public class Problem3110 {
    public static void main(String[] args) {
        String s = "zaz";
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        System.out.println(sum);
    }
}
