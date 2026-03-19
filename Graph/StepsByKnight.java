import java.util.*;

class Pair {
    int i;
    int j;
    int distance;

    public Pair(int i, int j, int distance) {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }
}

class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        int[] possibleValueOfi = { -2, -2, -1, -1, 1, 1, 2, 2 };
        int[] possibleValueOfj = { -1, 1, -2, 2, -2, 2, -1, 1 };
        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(knightPos[0], knightPos[1], 0));
        visited[knightPos[0]][knightPos[1]] = true;
        while (!q.isEmpty()) {
            Pair current = q.poll();
            if (current.i == targetPos[0] && current.j == targetPos[1]) {
                return current.distance;
            }
            for (int i = 0; i < 8; i++) {
                int tempi = current.i + possibleValueOfi[i];
                int tempj = current.j + possibleValueOfj[i];

                if (tempi <= n && tempj <= n && tempi >= 1 && tempj >= 1) {
                    if (!visited[tempi][tempj]) {
                        visited[tempi][tempj] = true;
                        q.offer(new Pair(tempi, tempj, current.distance + 1));
                    }
                }

            }
        }
        return -1;
    }
}

public class StepsByKnight {
    public static void main(String[] args) {
        int[] knightPosition = { 1, 1 };
        int[] targetPosition = { 7, 5 };
        int n = 7;
        Solution s = new Solution();
        System.out.println(s.minStepToReachTarget(knightPosition, targetPosition, n));
    }
}