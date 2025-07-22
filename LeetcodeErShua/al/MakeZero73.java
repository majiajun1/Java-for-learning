/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.List;

public class MakeZero73 {
    public void setZeroes(int[][] matrix) {
        List<int[]> located = new ArrayList<int[]>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    located.add(new int[]{i, j});
                }
            }
        }
        for(int[] locatedRow : located) {
            int x = locatedRow[0];
            int y = locatedRow[1];
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][y] = 0;
            }
            for (int k = 0; k < matrix[0].length; k++) {
                matrix[x][k] = 0;
            }
        }
    }
}
