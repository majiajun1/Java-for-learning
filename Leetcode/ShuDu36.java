import java.util.HashMap;
import java.util.HashSet;

public class ShuDu36 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {;
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> row = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.'){
                     if(row.contains(board[i][j])){
                         return false;
                     }
                     else
                     {
                         row.add(board[i][j]);
                     }
                }


            }

        }
        for (int j = 0; j < board.length; j++) {
            HashSet<Character> col = new HashSet<>();
            for (int i = 0; i < board[j].length; i++) {
                if(board[i][j] != '.'){
                     if(col.contains(board[i][j])){
                         return false;
                     }
                     else
                     {
                         col.add(board[i][j]);
                     }
                }
            }

        }
        for (int subgridRow = 0; subgridRow < 3; subgridRow++) {
        for (int subgridCol = 0; subgridCol < 3; subgridCol++) {
             HashSet<Character> block = new HashSet<>();
            // 遍历当前九宫格内的元素
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = subgridRow * 3 + i;
                    int col = subgridCol * 3 + j;
                    if(board[row][col] != '.'){
                        if(block.contains(board[row][col])){
                            return false;
                        }
                        else {
                            block.add(board[row][col]);
                        }
                    }
                }

            }

        }
    }



        return true;
    }
}
