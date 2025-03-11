public class Problem9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1));
    }

    public static boolean isPalindrome(int x) {

        int rev = 0 , i = x;
        while (i >= 1){
            rev = rev * 10 + i % 10;
            i = i / 10;
        }
        return rev == x;
    }
}
