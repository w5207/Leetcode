import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
  private static final int[] xBias = { 0, 0, 1, -1 };
  private static final int[] yBias = { 1, -1, 0, 0 };

  private int count;

  public int numIslands(char[][] grid) {
    count = 0;
    if (grid == null || grid.length == 0) {
      return count;
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          bfs(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  private void bfs(char[][] grid, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;
    grid[i][j] = '2';
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(i * n + j);
    while (!queue.isEmpty()) {
      int num = queue.poll();
      i = num / n;
      j = num % n;
      for (int k = 0; k < xBias.length; k++) {
        int newI = i + xBias[k];
        int newJ = j + yBias[k];
        if (newI < 0 || newJ < 0 || newI >= m || newJ >= n || grid[newI][newJ] != '1') {
          continue;
        }
        queue.offer(newI * n + newJ);
        grid[newI][newJ] = '2';
      }
    }
  }
}