import java.util.Arrays;
import java.util.HashMap;

public class Problem1 {
    public static void main(String[] args) {
        int[] nums = {3,2,4,2};
        int target = 6;
        int[] result = new int[2];

        for (int i = 0, j = i + 1; i < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;
                break;
            }

            if (j == nums.length - 1) {
                i++;
                j = i;
            }


        }
        System.out.println(Arrays.toString(result));
    }

    public class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i]  + nums[j] == target){
                        int[] retValue = {i, j};
                        return retValue;
                    }
                }
            }
            return null;
        }
    }

    public class Solution3 {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }

    }


}
