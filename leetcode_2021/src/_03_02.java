public class _03_02 {


    class NumMatrix {

        int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = 0;
            for (int i = col1; i <= col2; i++) {
                for (int j = row1; j <= row2; j++) {
                    res += matrix[j][i];
                }
            }

            return res;
        }


//        int[][] matrix = new int[][]{};
//        NumMatrix obj = new NumMatrix(matrix);
//
//        int row1, col1, row2, col2;
//        int param_1 = obj.sumRegion(row1, col1, row2, col2);
    }


    class NumMatrix1 {
        int[][] temp;

        public NumMatrix1(int[][] matrix) {
            int m = matrix.length;

            if (m == 0) return;

            int n = matrix[0].length;

            temp = new int[m + 1][n + 1];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i + 1][j + 1] = temp[i + 1][j] + temp[i][j + 1] - temp[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return temp[row2 + 1][col2 + 1] - temp[row1][col2 + 1] - temp[row2 + 1][col1] + temp[row1][col1];
        }
    }


}
