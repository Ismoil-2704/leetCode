public class Problem2710 {
    public static void main(String[] args) {
        String num = "123";

        for (int i = num.length() - 1; i > 0; i--) {
            if (num.charAt(i) == '0') num =  num.substring(0,i);
            else break;
        }
        System.out.println(num);
    }
}
