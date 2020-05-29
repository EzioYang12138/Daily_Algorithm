public class _5_29 {

//    https://leetcode-cn.com/problems/house-robber/

    public int rot(int[] nums) {
        if(nums.length == 0) return 0;
        else if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1];


        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i] , dp[i-1]);
        }

        return dp[nums.length - 1];
    }
}
