import java.util.*;

public class KeyAndRoom841 {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms = Arrays.asList(
                Arrays.asList(1), // Room 0
                Arrays.asList(2),   // Room 1
                Arrays.asList(3),       // Room 2
                Arrays.asList()        // Room 3
        );
        boolean ans = canVisitAllRooms(rooms);
        System.out.println(ans);

    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {  //bfs or dfs
            Deque<Integer> stack = new ArrayDeque<>();
            stack.offer(0);
            boolean[] visited = new boolean[rooms.size()];
            visited[0] = true;
            while (!stack.isEmpty()) {
                int cur = stack.poll();
                List<Integer> curRoom = rooms.get(cur);
                for(int j:curRoom)
                {
                    if(!visited[j])
                    {
                        visited[j] = true;
                        stack.offer(j);
                    }

                }
            }
            for (int i = 0; i < rooms.size(); i++) {
                if(!visited[i])
                {
                    return false;
                }
            }
            return true;


    }



}
