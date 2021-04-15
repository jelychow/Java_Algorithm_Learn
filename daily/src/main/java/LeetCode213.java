import java.util.Arrays;

public class LeetCode213 {
    public int rob(int[] nums) {

        if (nums.length==0) {
            return 0;
        }
        if (nums.length==1) {
            return nums[0];
        }

        return Math.max(helper(Arrays.copyOfRange(nums,0,nums.length-1)),helper(Arrays.copyOfRange(nums,1,nums.length)));
    }

    // 打家劫舍的模板题 打家劫舍1
    public int helper(int[] nums) {
        if(nums.length==0) {
            return 0;
        }
        if (nums.length==1) {
            return  nums[0];
        }
        if (nums.length==2) {
            return  Math.max(nums[0],nums[1]);
        }
        int max = 0;
        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        max = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (i-3>=0) {
                dp[i] =Math.max(dp[i-2],dp[i-3]) + nums[i];
            } else {
                dp[i] =dp[i-2] + nums[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
