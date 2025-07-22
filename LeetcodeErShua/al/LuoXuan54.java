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
import java.util.List;

public class LuoXuan54 {
    public static void main(String[] args) {
        int[][] cur={{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for(int i:spiralOrder(cur))
        {
            System.out.println(i);
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int upLimit = 0;
        int downLimit = matrix.length-1;
        int leftLimit = 0;
        int rightLimit = matrix[0].length-1;

        int rowIndex=upLimit;
        int colIndex=leftLimit;
        List<Integer> list=new ArrayList<>();
        boolean[][] visited=new boolean[matrix.length][matrix[0].length];


        while(list.size()<matrix.length*matrix[0].length)
        {
            //go right
            while (colIndex<=rightLimit)
            {
                if(!visited[rowIndex][colIndex]) {
                    list.add(matrix[rowIndex][colIndex]);
                    visited[rowIndex][colIndex] = true;
                }
                colIndex++;
            }
            upLimit++;
            colIndex--;
            //go down
            while (rowIndex<=downLimit)
            {
                if(!visited[rowIndex][colIndex]) {
                    list.add(matrix[rowIndex][colIndex]);
                    visited[rowIndex][colIndex] = true;
                }
                rowIndex++;
            }
            rightLimit--;
            rowIndex--;
            //go left
            while (colIndex>=leftLimit)
            {
                if(!visited[rowIndex][colIndex]) {
                    list.add(matrix[rowIndex][colIndex]);
                    visited[rowIndex][colIndex] = true;
                }
                colIndex--;
            }
            downLimit--;
            colIndex++;

            //go up
            while (rowIndex>=upLimit)
            {
                if(!visited[rowIndex][colIndex]) {
                    list.add(matrix[rowIndex][colIndex]);
                    visited[rowIndex][colIndex] = true;
                }
                rowIndex--;
            }
            leftLimit++;
            rowIndex++;


        }



        return list;
    }
}
