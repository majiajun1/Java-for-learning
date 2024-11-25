import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

public class ProvinceNum547 {
    public static void main(String[] args) {

    }

     public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // 节点总数
        HashSet<Integer> visited = new HashSet<>(); // 记录已访问的节点
        int provinceCount = 0; // 省份计数

        // 遍历每个节点
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) { // 如果该节点未被访问
                dfs(isConnected, visited, i); // 从该节点开始进行DFS
                provinceCount++; // 每完成一个DFS，说明找到了一个新的连通分量
            }
        }

        return provinceCount;
    }


     private static void dfs(int[][] isConnected, HashSet<Integer> visited, int node) {
        visited.add(node); // 将当前节点标记为已访问

        // 遍历与当前节点相邻的所有节点
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited.contains(i)) {
                dfs(isConnected, visited, i); // 递归访问未访问的邻居节点
            }
        }
    }

}
