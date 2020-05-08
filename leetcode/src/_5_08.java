public class _5_08 {

//    https://leetcode-cn.com/problems/maximal-square/submissions/

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        dp[0][0] = 1;

        int length = 0;

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j] , Math.min(dp[i][j-1] , dp[i-1][j-1])) + 1;
                    length = Math.max(dp[i][j] , length);
                }
            }
        }

        return length * length;
    }
}
