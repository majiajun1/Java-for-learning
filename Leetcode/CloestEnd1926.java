import java.util.LinkedList;
import java.util.Queue;

public class CloestEnd1926 {
    public static int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        // 定义四个方向
        int[][] directions = {
            {0, 1},  // 右
            {1, 0},  // 下
            {0, -1}, // 左
            {-1, 0}  // 上
        };

        // BFS 队列，存储 [x, y, 步数]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        // 标记入口为访问过
        maze[entrance[0]][entrance[1]] = '+';

        // 开始 BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            // 检查四个方向
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // 判断是否在迷宫范围内并且是通路
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] == '.') {
                    // 如果是出口（在边界且不是入口）
                    if (newX == 0 || newX == rows - 1 || newY == 0 || newY == cols - 1) {
                        return steps + 1;
                    }

                    // 标记为访问过并加入队列
                    maze[newX][newY] = '+';
                    queue.offer(new int[]{newX, newY, steps + 1});
                }
            }
        }

        // 如果没有出口，返回 -1
        return -1;
    }
}
