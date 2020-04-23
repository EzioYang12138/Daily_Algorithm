import java.util.Scanner;

public class _4_23 {

//    int res = 0;
//
//    public int waysToChange(int n) {
//
//
//        int[] nums = new int[]{25, 10, 5, 1};
//
//        helper(n, nums, 0, 0);
//
//
//        return res % 1000000007;
//    }
//
//    public void helper(int n, int[] nums, int temp, int start) {
//        if (temp > n) {
//            return;
//        }
//        if (temp == n) {
//            res++;
//            return;
//        }
//
//        for (int i = start; i < nums.length; i++) {
//            temp += nums[i];
//            helper(n, nums, temp, i);
//            temp -= nums[i];
//        }
//    }

    private final int MOD = (int) Math.pow(10, 9) + 7;

    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]);
            }
        }

        return dp[n] % MOD;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = new _4_23().waysToChange(n);

        System.out.println(res);
    }


}
