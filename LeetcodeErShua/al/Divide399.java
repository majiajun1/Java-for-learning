/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Divide399 {
    private static final String DELIMITER = "->";

    HashMap<String, List<String>> pointer = new HashMap<>();
    HashMap<String, Double> edge = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 构建图
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String from = equation.get(0);
            String to = equation.get(1);

            // 添加正向边
            pointer.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            // 添加反向边
            pointer.computeIfAbsent(to, k -> new ArrayList<>()).add(from);

            // 使用分隔符构建边的键
            edge.put(from + DELIMITER + to, values[i]);
            edge.put(to + DELIMITER + from, 1.0 / values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);

            // 检查节点是否存在于图中
            if (!pointer.containsKey(from) || !pointer.containsKey(to)) {
                result[i] = -1.0;
                continue;
            }

            // 处理直接相连的情况
            String directEdge = from + DELIMITER + to;
            if (edge.containsKey(directEdge)) {
                result[i] = edge.get(directEdge);
                continue;
            }

            // 使用DFS查找路径
            Set<String> visited = new HashSet<>();
            result[i] = dfs(from, to, visited);
        }

        return result;
    }

    // 递归DFS查找路径权重乘积
    private double dfs(String current, String target, Set<String> visited) {
        // 如果到达目标节点，返回权重1.0
        if (current.equals(target)) {
            return 1.0;
        }

        // 标记当前节点为已访问
        visited.add(current);

        // 获取所有邻居节点
        List<String> neighbors = pointer.get(current);
        if (neighbors != null) {
            for (String neighbor : neighbors) {
                // 跳过已访问的节点
                if (visited.contains(neighbor)) {
                    continue;
                }

                // 获取当前边的权重
                double currentWeight = edge.get(current + DELIMITER + neighbor);

                // 递归计算剩余路径的权重
                double remainingWeight = dfs(neighbor, target, visited);

                // 如果找到了有效路径，返回权重乘积
                if (remainingWeight != -1.0) {
                    return currentWeight * remainingWeight;
                }
            }
        }

        // 回溯：移除当前节点的访问标记
        visited.remove(current);
        return -1.0;
    }
}


