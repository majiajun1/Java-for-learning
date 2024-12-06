import java.util.LinkedList;
import java.util.Queue;

public class CorruptedOrange994 {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int answer= orangesRotting(grid);
        System.out.println(answer);
    }
    public static int orangesRotting(int[][] grid) {
         int rows = grid.length;
        int cols = grid[0].length;

        // 用队列存储腐烂橘子的坐标和时间
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0}); // {x, y, time}
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

         while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int time = current[2];
            minutes = time;

            // 遍历四个方向
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // 如果新位置是新鲜橘子，感染它
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2; // 标记为腐烂
                    queue.offer(new int[]{newX, newY, time + 1});
                    freshCount--; // 新鲜橘子数量减1
                }
            }
        }
         return freshCount == 0 ? minutes : -1;
    }


}
