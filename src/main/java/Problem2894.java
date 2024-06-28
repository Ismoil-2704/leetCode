public class Problem2894 {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int totalSum = n * (n + 1) / 2;

        // Number of multiples of m up to n
        int k = n / m;

        // Sum of multiples of m up to n
        int sumD = m * k * (k + 1) / 2;
        System.out.println(totalSum - sumD);
    }
}
