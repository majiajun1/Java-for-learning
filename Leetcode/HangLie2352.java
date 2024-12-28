import java.util.HashSet;
import java.util.*;

public class HangLie2352 {
    public static void main(String[] args) {
        int[][] grid={{3,2,1},{1,7,6},{2,7,7}};
        int ans=equalPairs(grid);
        System.out.println(grid.length);
        System.out.println(ans);
    }

    public static int equalPairs(int[][] grid) {
        int [][] grid2 = new int[grid.length][grid.length];
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2.length; j++) {
                grid2[i][j] = grid[j][i];
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(Arrays.equals(grid[i], grid2[j])){
                    count++;
                }
            }
        }
        return count;
    }


}
