import java.util.Queue;
import java.util.LinkedList;
class RecentCounter{
   public Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.add(t);
        while (!requests.isEmpty()&&requests.peek()<t-3000) {
                requests.poll();
        }

         return requests.size();
    }

}
