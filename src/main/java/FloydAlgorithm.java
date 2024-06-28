import java.util.Vector;

public class FloydAlgorithm {

    static int findDuplicateNum(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];
        do {
            if (fast > nums.length -1) return -1;
            int num_f = nums[fast];
            if (num_f > nums.length -1) return -1;
            slow = nums[slow];
            fast = nums[num_f];
        }while(slow != fast);

        return fast;

    }

    public static void main(String[] args) {
        int[] arr = {3,3};
        int duplicateNum = findDuplicateNum(arr);
        System.out.println(duplicateNum);
    }
}
