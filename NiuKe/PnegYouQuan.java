import  java.util.*;
public class PnegYouQuan {


    public static void main(String[] args) {//干脆就BFS了 找多少层

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();


        for (int i = 0; i < n; i++) {
            int count = sc.nextInt();
            sc.nextLine();

            Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
            Set<Integer> nodes = new HashSet<>();

            for (int j = 0; j < count; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph.putIfAbsent(a, new ArrayList<>());
                graph.putIfAbsent(b, new ArrayList<>());

                graph.get(a).add(b);
                graph.get(b).add(a);

                nodes.add(a);
                nodes.add(b);
            }


            int maxDepth = 0;


            for (int u : nodes) {
                Set<Integer> visited = new HashSet<>();

                if (!visited.contains(u)) {
                    // 进行 BFS
                    ArrayDeque<Integer> q = new ArrayDeque<>();
                    q.add(u);
                    visited.add(u);
                    int level = 0;

                    while (!q.isEmpty()) {
                        int size = q.size();
                        for (int k = 0; k < size; k++) {
                            int cur = q.poll();
                            for (int neighbor : graph.get(cur)) {
                                if (!visited.contains(neighbor)) {
                                    visited.add(neighbor);
                                    q.add(neighbor);  // 正确的BFS队列操作
                                }
                            }
                        }
                        level++; // 每处理完一层，深度加1
                    }
                    maxDepth = Math.max(maxDepth, level); // 更新最大深度
                }



            }

            System.out.println(maxDepth);
        }
    }



}
