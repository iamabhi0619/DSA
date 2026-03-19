public class matrixBorderSum {
    public static int matrixBorderSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;

        for (int j = 0; j < n; j++) {
            sum += grid[0][j];
        }

        if (m > 1) {
            for (int j = 0; j < n; j++) {
                sum += grid[m - 1][j];
            }
        }

        for (int i = 1; i < m - 1; i++) {
            sum += grid[i][0];
            if (n > 1) {
                sum += grid[i][n - 1];
            }
        }

        return sum;
    }

}
