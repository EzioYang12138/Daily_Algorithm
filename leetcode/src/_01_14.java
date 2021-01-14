import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode-cn.com/problems/robot-in-a-grid-lcci/

public class _01_14 {

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList<>();

        return helper(obstacleGrid, 0, 0, res) ? res : new ArrayList<>();

    }

    private boolean helper(int[][] obstacleGrid, int i, int j, List<List<Integer>> res) {
        if (i >= obstacleGrid.length || i < 0 || j >= obstacleGrid[i].length || j < 0 || obstacleGrid[i][j] == 1) {
            return false;
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(i);
        temp.add(j);
        res.add(temp);


        if (i == obstacleGrid.length - 1 && j == obstacleGrid[i].length - 1) {
            return true;
        }

        if (helper(obstacleGrid, i + 1, j, res) || helper(obstacleGrid, i, j + 1, res)) {
            return true;
        } else {
            res.remove(res.size() - 1);
            obstacleGrid[i][j] = 1;
            return false;
        }

    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        List<List<Integer>> res = new _01_14().pathWithObstacles(obstacleGrid);

        System.out.println(res);
    }
}
