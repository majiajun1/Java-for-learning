import java.util.ArrayList;
import java.util.List;

public class LessonTableTwo210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }
          int[] visited = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, visited,order)) {
                return new int[ ]{};
            }
        }
        return order.stream().mapToInt(i -> i).toArray();

    }


    private static boolean hasCycle(int course, List<List<Integer>> graph, int[] visited,List<Integer> Seq) {
        if (visited[course] == 1) return true;  // 发现环
        if (visited[course] == 2) return false; // 之前已访问，无需重复

        visited[course] = 1; // 标记为访问中
        for (int next : graph.get(course)) {
            if (hasCycle(next, graph, visited,Seq)) {
                return true;
            }
        }
        Seq.add(course);
        visited[course] = 2; // 标记为访问完毕

        return false;
    }
}
