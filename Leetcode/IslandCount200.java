


import java.util.*;

public class IslandCount200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0; // 统计岛屿数量

        // 遍历整个网格
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') { // 找到一个新的岛屿
                    count++;
                    bfs(grid, i, j); // 用 BFS 遍历该岛屿
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>() ;
        queue.offer(new int[]{x, y});
        grid[x][y] = '0'; // 标记已访问的陆地

        // 定义四个方向（上、下、左、右）
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int r = point[0], c = point[1];

            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                // 检查边界条件，并确保是陆地
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0'; // 标记为已访问
                }
            }
        }
    }
}