class Solution {

  public int[][] updateMatrix(int[][] mat) {
    boolean[][] visited = new boolean[mat.length][mat[0].length];
    int[][] dist = new int[mat.length][mat[0].length];
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    Queue<int[]> q = new ArrayDeque<>();

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 0) {
          q.offer(new int[] { i, j });
          visited[i][j] = true;
        }
      }
    }

    while (!q.isEmpty()) {
      int[] cell = q.poll();
      int x = cell[0];
      int y = cell[1];
      for (int[] dir : dirs) {
        int newx = x + dir[0];
        int newy = y + dir[1];
        if (
          newx >= 0 &&
          newx < mat.length &&
          newy >= 0 &&
          newy < mat[0].length &&
          !visited[newx][newy]
        ) {
          dist[newx][newy] = dist[x][y] + 1;
          q.offer(new int[] { newx, newy });
          visited[newx][newy] = true;
        }
      }
    }

    return dist;
  }
}
