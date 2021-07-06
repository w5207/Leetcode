class Solution {

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(start);
    visited[start[0]][start[1]] = true;
    while (!queue.isEmpty()) {
      int[] s = queue.poll();
      if (s[0] == destination[0] && s[1] == destination[1]) return true;
      for (int[] dir : dirs) {
        // 因为要满足maze[x][y] == 0的条件
        int x = s[0] + dir[0];
        int y = s[1] + dir[1];
        while (
          x >= 0 &&
          y >= 0 &&
          x < maze.length &&
          y < maze[0].length &&
          maze[x][y] == 0
        ) {
          x += dir[0];
          y += dir[1];
        }
        if (!visited[x - dir[0]][y - dir[1]]) {
          queue.offer(new int[] { x - dir[0], y - dir[1] });
          visited[x - dir[0]][y - dir[1]] = true;
        }
      }
    }
    return false;
  }
}
