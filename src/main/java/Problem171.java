public class Problem171 {
    public static void main(String[] args) {
        String columnTitle = "AB";
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int value = columnTitle.charAt(i) - 'A' + 1;//example 'AB'-'A'
            res = res * 26 + value;

        }
        System.out.println(res);
    }
}
