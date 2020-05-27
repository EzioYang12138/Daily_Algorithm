public class _5_27 {

//    https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/submissions/

    public int subarraysDivByK(int[] A  , int K) {
        int[] dp = new int[K];

        int sum =  0;
        int t = 0;
        int res = 0;
        int i = 0;


        for(; i< A.length; i++) {
            sum += A[i];

            if(sum % K < 0) {
                t = sum % K  + K;
            }else {
                t = sum % K;
            }


            if(t == 0) {
                dp[0] += 1;
                res += dp[0];
            }else if(dp[t] == 0) {
                dp[t] = 1;
            }else {
                res += dp[t];
                dp[t] += 1;
            }
        }


        return res;
    }
}
