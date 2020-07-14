import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/triangle/

public class _7_14 {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);

            for (int j = 0; j < cur.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j + 1], dp[i + 1][j]) + cur.get(j);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {

//        List<List<Integer>> triangle = ;

//        int res = new _7_14().minimumTotal(triangle);

//        System.out.println(res);
    }
}
