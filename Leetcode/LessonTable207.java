import java.util.*;

public class LessonTable207 {

    public static void main(String[] args) {

        int[][] temp = {{2, 0}, {1, 2}, {2, 0}};
        System.out.println(canFinish(20, temp));
    }

//    public static boolean canFinish(int numCourses, int[][] prerequisites) {  //找有没有环  这题完全理解错了
//        //之前的想法是根据课程表来查有多少门课  现在只是让你看有没有环
//        //一直出错在于 两个节点也能形成环   只求入度为0的点 会出BUG
//
//        if (numCourses == 0 || prerequisites.length == 0||prerequisites.length==1) return true;
//        Map<Integer, HashSet<Integer>> map = new HashMap<>();
//
//        HashSet<Integer> PointFrom = new HashSet<>();
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            map.putIfAbsent(prerequisites[i][0], new HashSet<>());
//            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
//            if(prerequisites[i][1]==prerequisites[i][0]){return false;}
//
//            PointFrom.add(prerequisites[i][0]);
//
//        }
//
//        HashSet<Integer> visited = new HashSet<>();
//       for (Integer key : PointFrom) {
//
//            if (!canFinish2(key, map, visited)) {
//                return false;
//            }
//        }
//        return true;
//
//
//    }
//
//    public static boolean canFinish2(int start, Map<Integer, HashSet<Integer>> map, HashSet<Integer> visited) {
//
//        if (visited.contains(start)) return false;
//
//        visited.add(start);
//        if(!map.containsKey(start)){visited.remove(start); return true;}
//
//        for (int key : map.get(start)) {
//            if (!canFinish2(key, map, visited)) {
//                return false;  // 如果某个节点不能完成课程，则返回 false
//            }
//        }
//         visited.remove(start);
//        return true;
//    }

        public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasCycle(int course, List<List<Integer>> graph, int[] visited) {
        if (visited[course] == 1) return true;  // 发现环
        if (visited[course] == 2) return false; // 之前已访问，无需重复

        visited[course] = 1; // 标记为访问中
        for (int next : graph.get(course)) {
            if (hasCycle(next, graph, visited)) {
                return true;
            }
        }
        visited[course] = 2; // 标记为访问完毕
        return false;
    }
}



