/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.plaf.PanelUI;

public class CountIsland200 {
    ArrayList<int[]> listofPoints;
    public int numIslands(char[][] grid) {
        listofPoints = new ArrayList<>();
        boolean[][] island = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    island[i][j] = false;
                    listofPoints.add(new int[]{i, j});
                }else
                {
                    island[i][j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < listofPoints.size(); i++) {
            int[] cur=listofPoints.get(i);
            int row=cur[0];
            int col=cur[1];
            if(!island[row][col]){
                BFS(row,col,grid,island);
                count++;

            }
        }
        return count;

    }

    public void BFS(int row, int col, char[][] grid, boolean[][] island) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                int[] cur = queue.poll();
                int row1 = cur[0];
                int col1 = cur[1];

                if(island[row1][col1]){
                    continue;
                }

                island[row1][col1] = true;

                if(row1>0&&grid[row1-1][col1]=='1'){
                    queue.addLast(new int[]{row1-1,col1});
                }
                if (1<grid.length-1&&grid[row1+1][col1]=='1'){
                    queue.addLast(new int[]{row1+1,col1});
                }

                if(col1>0&&grid[row1][col1-1]=='1'){
                    queue.addLast(new int[]{row1,col1-1});
                }
                if (col1<grid[row1].length-1&&grid[row1][col1+1]=='1'){
                    queue.addLast(new int[]{row1,col1+1});
                }
            }
        }


    }
}
