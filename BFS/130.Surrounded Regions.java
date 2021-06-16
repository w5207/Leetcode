class Solution {
  private static final int[] xBias = { 0, 0, 1, -1 };
  private static final int[] yBias = { 1, -1, 0, 0 };

  public class Pos {
    int i;
    int j;

    Pos(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  public void solve(char[][] board) {
    if (board == null || board.length == 0)
      return;
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
        if (isEdge && board[i][j] == 'O') {
          bfs(board, i, j);
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
        if (board[i][j] == '#') {
          board[i][j] = 'O';
        }
      }
    }
  }

  private void bfs(char[][] board, int i, int j) {
    int m = board.length;
    int n = board[0].length;
    board[i][j] = '#';
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(i * n + j);
    while (!queue.isEmpty()) {
      int num = queue.poll();
      i = num / n;
      j = num % n;
      for (int k = 0; k < xBias.length; k++) {
        int newI = i + xBias[k];
        int newJ = j + yBias[k];
        if (newI < 0 || newJ < 0 || newI >= m || newJ >= n || board[newI][newJ] != 'O') {
          continue;
        }
        queue.offer(newI * n + newJ);
        board[newI][newJ] = '#';
      }
    }
  }
}
