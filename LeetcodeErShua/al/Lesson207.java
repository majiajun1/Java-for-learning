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
import java.util.HashMap;
import java.util.List;

public class Lesson207 {
    int[] visited;
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        Arrays.fill(visited, 0);  //0未访问  1已访问可达  2已访问不可达

        // 修正图的构建：[a,b]表示a依赖b，即b是a的前置，边为 b → a
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];  // 课程a
            int b = prerequisites[i][1];  // 前置课程b
            if (map.containsKey(b)) {
                map.get(b).add(a);  // 依赖关系：b → a（学a前必须学b）
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                map.put(b, list);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                // 若DFS检测到环，直接返回false
                if (dfs(i) == 2) {
                    return false;
                }else
                {

                }
            }
        }
        return true;


    }

    public int dfs(int node) {
        if (visited[node] == 2) {
            // 遇到“正在访问”的节点，说明有环
            return 2;
        }
        if (visited[node] == 1) {
            // 已访问且无环，直接返回
            return 1;
        }
        // 标记为正在访问（2表示不可达/存在环）
        visited[node] = 2;

        // 遍历所有依赖的前置课程
        if (map.containsKey(node)) {
            for (int neighbor : map.get(node)) {
                // 如果邻居节点未被访问，则递归检查
                if (visited[neighbor] == 0) {
                    if (dfs(neighbor) == 2) {
                        return 2; // 发现环，返回不可达
                    }
                }
                // 如果邻居节点正在被访问（状态2），说明存在环
                else if (visited[neighbor] == 2) {
                    return 2;
                }
            }
        }

        // 所有依赖课程都可达，标记当前节点为已访问且可达
        visited[node] = 1;
        return 1;
    }
}
