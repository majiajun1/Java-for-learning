

import java.util.Collections;
import java.util.PriorityQueue;

public class ShuzuKthMaxEleErShua215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }

        int ans=0;
        int index=0;
        while(index!=k)
        {
            ans=pq.poll();
            index++;
        }
        return ans;

    }
}
