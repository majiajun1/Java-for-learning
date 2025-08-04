/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

public class Search79 {
    String word;
    public boolean exist(char[][] board, String word) {
        char begin = word.charAt(0);
        boolean[][] visited = new boolean[board.length][board[0].length];
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == begin) {
                    if(dfs(visited,board,i,j,0))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(boolean[][] visited, char[][] board, int row,int col,int index) {


        if(row<0 || row>=board.length || col<0 || col>=board[0].length)
            return false;

        if(visited[row][col]||word.charAt(index) != board[row][col]) {
            return false;
        }

        if(index == word.length()-1)
        {
            return true;
        }


            visited[row][col] = true;

            boolean flag= dfs(visited, board, row, col+1, index+1)
                    ||dfs(visited, board, row,col-1, index+1)
                    ||dfs(visited, board, row+1, col,index+1)
                    ||dfs(visited, board, row-1, col, index+1);
            visited[row][col] = false;
            return flag;




    }
}
