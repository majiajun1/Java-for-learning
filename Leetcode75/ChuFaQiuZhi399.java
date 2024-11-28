
import java.util.*;
public class ChuFaQiuZhi399 {
    public static void main(String[] args) {

    }

        // Step 1: Build the graph
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build the graph with equations
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            // Add both directions to the graph
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        // Step 2: Process each query
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);

            // If either start or end is not in the graph, the result is -1.0
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(start, end, graph, visited);
            }
        }

        return result;
    }

    // Step 3: DFS helper function to find the value of start / end
    private static double dfs(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited) {
        // If start equals end, the answer is 1.0
        if (start.equals(end)) {
            return 1.0;
        }

        visited.add(start);

        for (Map.Entry<String, Double> entry : graph.get(start).entrySet()) {
            String neighbor = entry.getKey();
            double value = entry.getValue();

            // If the neighbor has not been visited yet, continue DFS
            if (!visited.contains(neighbor)) {
                double result = dfs(neighbor, end, graph, visited);

                // If a valid path is found, return the product of the value
                if (result != -1.0) {
                    return result * value;
                }
            }
        }

        return -1.0;  // If no path is found, return -1.0
    }
}
