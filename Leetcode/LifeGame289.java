public class LifeGame289 {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(matrix);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
        }
    }

    public static void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        int m = board.length;
        int n = board[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (board[row][col] == 1) {
                    int count=LiveCount(row,col,board);
                    if(count<2) {
                        newBoard[row][col] = 0;
                    }
                    else if(count==2||count==3)
                        newBoard[row][col] = 1;
                    else if (count>3)
                    {
                        newBoard[row][col] = 0;
                    }
                }
                else
                {
                    int count=LiveCount(row,col,board);
                    if(count==3)
                        newBoard[row][col] = 1;
                }
            }
        }
        for (int row = 0; row < m; row++) {
        for (int col = 0; col < n; col++) {
            board[row][col] = newBoard[row][col];
        }
    }
    }

    public static int LiveCount(int row, int col, int[][] board) {
    int m = board.length; // 行数
    int n = board[0].length; // 列数

    int count = 0;
    int topRow = row - 1;
    int bottomRow = row + 1;
    int leftCol = col - 1;
    int rightCol = col + 1;

    // 检查并累加上方的三个位置
    if (topRow >= 0) {
        if (board[topRow][col] == 1) count++; // 上方中间
        if (leftCol >= 0 && board[topRow][leftCol] == 1) count++; // 左上
        if (rightCol < n && board[topRow][rightCol] == 1) count++; // 右上
    }

    // 检查并累加中间左右位置
    if (leftCol >= 0 && board[row][leftCol] == 1) count++; // 左
    if (rightCol < n && board[row][rightCol] == 1) count++; // 右

    // 检查并累加下方的三个位置
    if (bottomRow < m) {
        if (board[bottomRow][col] == 1) count++; // 下方中间
        if (leftCol >= 0 && board[bottomRow][leftCol] == 1) count++; // 左下
        if (rightCol < n && board[bottomRow][rightCol] == 1) count++; // 右下
    }

    return count;
    }

}
