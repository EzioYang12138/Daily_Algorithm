public class _4_20 {


//    https://leetcode-cn.com/problems/number-of-islands/

    public int numIslands(char[][] grid) {

        if(grid.length == 0 || grid[0].length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;

        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    helper(i, j, row, col, grid);
                    res++;
                }

            }
        }
        return res;
    }

    public void helper(int i, int j, int row, int col, char[][] grid) {

        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';

        helper(i - 1, j, row, col, grid);
        helper(i + 1, j, row, col, grid);
        helper(i, j + 1, row, col, grid);
        helper(i, j - 1, row, col, grid);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        int res = new _4_20().numIslands(grid);

        System.out.println(res);
    }
}
