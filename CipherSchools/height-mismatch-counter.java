
import java.util.Arrays;

class Solution {
    public static int solve(int[] nums) {
        int res = 0;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp[i])
                res++;
        }
        return res;
    }
}
