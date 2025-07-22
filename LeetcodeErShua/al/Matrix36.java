/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.HashSet;

public class Matrix36 {
    public boolean isValidSudoku(char[][] board) {

        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            if(!rank(board, i)) return false;
            if(!row(board, i)) return false;
        }
        for(int i = 0; i < board.length; i=i+3){
            for(int j = 0; j < board[i].length; j=j+3){
                if(!smallmatrix(board, i,j)) return false;
            }
        }



        return true;
    }

    public boolean rank(char[][] board, int row) {
        HashSet<Character> set = new HashSet<Character>();
        for (int col = 0; col < 9; col++)
        {
            if(board[row][col] == '.')
            {
                continue;
            }
            else {
                if(set.contains(board[row][col]))
                {
                    return false;
                }else
                {
                    set.add(board[row][col]);
                }
            }
        }
        return true;
    }

    public boolean row(char[][] board, int row) {
        HashSet<Character> set = new HashSet<Character>();
        for (int col = 0; col < 9; col++)
        {
            if(board[col][row] == '.')
            {
                continue;
            }
            else {
                if(set.contains(board[col][row]))
                {
                    return false;
                }else
                {
                    set.add(board[col][row]);
                }
            }
        }
        return true;
    }

    public boolean smallmatrix(char[][] board,int row,int col) {
        HashSet<Character> set = new HashSet<>();
        for(int i=row;i<=row+2;i++){
            for(int j=col;j<=col+2;j++){
                if(board[i][j] != '.'){
                    if(set.contains(board[i][j]))
                    {
                        return false;
                    }else
                    {
                        set.add(board[i][j]);
                    }
                }

            }
        }
        return true;
    }
}
