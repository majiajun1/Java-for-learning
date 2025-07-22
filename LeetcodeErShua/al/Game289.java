/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Game289 {
    public static void main(String[] args) {
        int[][] a= {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(a);
    }
    public static void gameOfLife(int[][] board) {
        ArrayList<int[]> al = new ArrayList<int[]>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                 al.add(new int[]{i, j, board[i][j]});
            }
        }
        ArrayList<int[]> changed=new ArrayList<>();
        int m = board.length-1;
        int n = board[0].length-1;
        for (int[] a : al) {
            int row = a[0];
            int col = a[1];
            int count = 0;
            int cur=a[2];
            if(col>0)
            {
                if(board[row][col-1]==1)
                {
                    count++;
                }
                if(row<m&&board[row+1][col-1]==1)
                {
                    count++;
                }
            }
            if(col<n)
            {
                if(board[row][col+1]==1)
                    count++;
                if(row<m&&board[row+1][col+1]==1)
                {
                    count++;
                }
            }

            if(row>0)
            {
                if(board[row-1][col]==1)
                    count++;
                if(col<n&&board[row-1][col+1]==1)
                    count++;

                if(col>0&&board[row-1][col-1]==1)
                    count++;
            }
            if(row<m)
            {
                if (board[row+1][col]==1) count++;

            }
            if(cur==1){
                if(count<2)
                {
                    changed.add(new int[]{row,col,0});
                } else if(count>3)
                {
                    changed.add(new int[]{row,col,0});
                }
            }
            else if(cur==0&&count==3)
            {
                changed.add(new int[]{row,col,1});
            }
        }
        for (int[] a : changed) {
            board[a[0]][a[1]] = a[2];
        }
    }
}
