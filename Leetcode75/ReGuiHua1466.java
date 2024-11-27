import java.util.*;
public class ReGuiHua1466 {
    public static void main(String[] args) {


    }

     public int minReorder(int n, int[][] connections) {
        // 构建邻接表
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            graph[connection[0]].add(new int[]{connection[1], 1}); // 原始方向
            graph[connection[1]].add(new int[]{connection[0], 0}); // 反向
        }

        // 初始化 BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int changeCount = 0;

        // 从节点 0 开始
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 遍历当前节点的所有邻居
            for (int[] neighbor : graph[current]) {
                int nextNode = neighbor[0];
                int direction = neighbor[1];

                // 如果未访问过该邻居
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                    changeCount += direction; // 原始方向需要调整
                }
            }
        }

        return changeCount;
    }
}