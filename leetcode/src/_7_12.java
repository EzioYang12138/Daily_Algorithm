public class _7_12 {

//    https://leetcode-cn.com/problems/dungeon-game/submissions/

    public int calculateMinimumHP(int[][] dungeon) {

        int row = dungeon.length - 1;
        int col = dungeon[0].length - 1;

        if (dungeon[row][col] < 0) {
            dungeon[row][col] = dungeon[row][col] * -1 + 1;
        } else {
            dungeon[row][col] = 1;
        }

        for (int i = row - 1; i >= 0; i--) {
            dungeon[i][col] = dungeon[i][col] >= dungeon[i + 1][col] ? 1 : dungeon[i + 1][col] - dungeon[i][col];
        }

        for (int i = col - 1; i >= 0; i--) {
            dungeon[row][i] = dungeon[row][i] >= dungeon[row][i + 1] ? 1 : dungeon[row][i + 1] - dungeon[row][i];
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                dungeon[i][j] = dungeon[i][j] >= Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) ? 1 :
                        Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j];
            }
        }

        return dungeon[0][0];

    }
}
