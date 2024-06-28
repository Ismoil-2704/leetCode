import java.util.HashMap;
import java.util.Map;

public class Problem2815 {


    public static void main(String[] args) {
        int[] nums = {51, 71, 17, 24, 42};
        Map<Integer, Integer> maxNumWithDigit = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int maxDigit = 0;
            int currentNum = num;
            while (currentNum > 0) {
                int digit = currentNum % 10;
                maxDigit = Math.max(maxDigit, digit);
                currentNum /= 10;
            }

            if (maxNumWithDigit.containsKey(maxDigit)) {
                int prevMax = maxNumWithDigit.get(maxDigit);
                maxSum = Math.max(maxSum, prevMax + num);
                if (num > prevMax) {
                    maxNumWithDigit.put(maxDigit, num);
                }
            } else {
                maxNumWithDigit.put(maxDigit, num);
            }
        }
        System.out.println(maxSum);
    }

}
