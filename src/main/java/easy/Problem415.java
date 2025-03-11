package easy;

public class Problem415 {
    public static void main(String[] args) {
        System.out.println(addStrings("1", "2"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int numFirst = 0;
            int numSecond = 0;
            if (i >= 0)
                numFirst = num1.charAt(i) - '0';

            if (j >= 0)
                numSecond = num2.charAt(j) - '0';

            numFirst += numSecond + carry;

            if (numFirst > 9) {
                result.append((numFirst % 10));
                carry = 1;
            } else {
                StringBuilder reverse = new StringBuilder().append(numFirst).reverse();
                result.append(reverse);
                carry = 0;
            }
            i--;
            j--;
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
