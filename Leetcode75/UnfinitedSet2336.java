import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class UnfinitedSet2336 {

    PriorityQueue<Integer> set;
    int min = 1;

    public UnfinitedSet2336() {
        set = new PriorityQueue<>();
    }

    public int popSmallest() {
        if (set.isEmpty()) {
            int tmp = min;
            min++;
            return tmp;
        } else {
            return set.poll();
        }
    }

    public void addBack(int num) {
        if (num < min && !set.contains(num)) {
            set.add(num);
        }
    }
}

