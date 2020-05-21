public class _5_20 {

//    https://leetcode-cn.com/problems/longest-palindromic-substring/

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int res = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (i - j <= 2) || dp[i - 1][j + 1]);

                if (dp[i][j]) {
                    if (i - j + 1 > res) {
                        res = Math.max(res, i - j + 1);

                        left = j;
                        right = i + 1;
                    }
                }

            }
        }


        return s.substring(left, right);
    }
}
