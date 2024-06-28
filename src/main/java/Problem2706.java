import java.util.Arrays;

public class Problem2706 {
    public static void main(String[] args) {
        int[] prices = {98,54,6,34,66,63,52,39};
        int money = 62;
        Arrays.sort(prices);
        System.out.println(prices[0] + prices[1] > money ? money : money - (prices[0] + prices[1]));
    }
}
