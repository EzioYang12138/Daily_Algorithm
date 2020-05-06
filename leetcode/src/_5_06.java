public class _5_06 {

//    https://leetcode-cn.com/problems/minimum-cost-for-tickets/submissions/

    public int mincostTickets(int[] days, int[] costs) {

        int n = days[days.length - 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i < days.length; i++) {
            dp[days[i]] = -1;
        }

        int a = 0, b = 0, c = 0;

        for (int i = 1; i <= n; i++) {
            if (dp[i] == 0) {
                dp[i] = dp[i - 1];
            } else {
                a = dp[i - 1] + costs[0];
                if (i >= 7) {
                    b = dp[i - 7] + costs[1];
                } else {
                    b = costs[1];
                }

                if (i >= 30) {
                    c = dp[i - 30] + costs[2];
                } else {
                    c = costs[2];
                }
            }

            dp[i] = Math.min(a, Math.min(b, c));
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] days = new int[]{1, 4, 6, 7, 8, 20};
        int[] costs = new int[]{2, 7, 15};
        int  res = new _5_06().mincostTickets(days, costs);

        System.out.println(res);
    }
}
