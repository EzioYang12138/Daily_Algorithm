public class _6_09 {

//    https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/submissions/

    public int translateNum(int num) {
        if(num < 10) {
            return 1;
        }

        String s = String.valueOf(num);
        int[] dp = new int[s.length()];

        dp[0] = 1;

        if(s.charAt(0) =='1' || s.charAt(0) == '2' && s.charAt(1) <'6') {
            dp[1] = dp[0] + 1;
        }else {
            dp[1] = dp[0];
        }

        for(int i = 2; i < s.length();i ++) {
            if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <'6') {
                dp[i] = dp[i-2] + dp[i-1];
            }else {
                dp[i] = dp[i-1];
            }
        }

        return dp[s.length() - 1];
    }
}
