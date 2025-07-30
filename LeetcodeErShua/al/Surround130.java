/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

public class Surround130 {
    //DFS until borader
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int rows = board.length;
        int cols = board[0].length;

        // 1. 从边界的'O'开始DFS，标记所有与边界相连的'O'为'T'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        // 2. 遍历整个棋盘：将未标记的'O'转换为'X'，将标记的'T'恢复为'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        // 标记当前'O'为'T'（已访问且与边界相连）
        board[row][col] = 'T';

        // 递归检查四个方向
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
    }
}
