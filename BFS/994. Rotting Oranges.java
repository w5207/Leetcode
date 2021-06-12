import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
  private static final int[] xBias = { 0, 0, 1, -1 };
  private static final int[] yBias = { 1, -1, 0, 0 };

  public int orangesRotting(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return -1;
    }
    int m = grid.length;
    int n = grid[0].length;
    Queue<Integer> queue = new ArrayDeque<>();
    int fresh = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          fresh++;
        } else if (grid[i][j] == 2) {
          queue.offer(i * n + j);
        }
      }
    }

    int minute = 0;
    while (!queue.isEmpty() && fresh != 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int index = queue.poll();
        int x = index / n;
        int y = index % n;
        for (int j = 0; j < xBias.length; j++) {
          int newX = x + xBias[j];
          int newY = y + yBias[j];
          if (notValid(grid, newX, newY)) {
            continue;
          }
          fresh--;
          queue.offer(newX * n + newY);
          grid[newX][newY] = 2;
        }
      }
      minute++;
    }
    return fresh == 0 ? minute : -1;
  }

  private boolean notValid(int[][] grid, int x, int y) {
    return x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1;
  }
}