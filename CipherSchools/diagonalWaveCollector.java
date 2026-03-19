import java.util.ArrayList;
import java.util.List;

public class diagonalWaveCollector {
    public static List<List<Integer>> diagonalWaveCollector(int[][] grid) {
        List<List<Integer>> result = new ArrayList<>();

        if (grid == null || grid.length == 0)
            return result;

        int m = grid.length;
        int n = grid[0].length;

        // There are m + n - 1 anti-diagonals
        for (int d = 0; d < m + n - 1; d++) {
            List<Integer> diagonal = new ArrayList<>();

            // Traverse rows
            for (int i = 0; i < m; i++) {
                int j = d - i;
                if (j >= 0 && j < n) {
                    diagonal.add(grid[i][j]);
                }
            }

            result.add(diagonal);
        }

        return result;
    }

}
