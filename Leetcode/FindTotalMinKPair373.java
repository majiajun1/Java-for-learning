import java.util.*;

public class FindTotalMinKPair373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]])));
        List<List<Integer>> ans = new ArrayList<>();
        int count = 0;
         for (int i = 0; i < Math.min(k, nums1.length); i++) {
        pq.offer(new int[]{i, 0});
    }



         while(count<k) {
             if (pq.isEmpty()) {
                 break;
             }
             int[] pair = pq.poll();
             int i = pair[0];
             int j = pair[1];

             // 将当前的组合放入结果中
             ans.add(Arrays.asList(nums1[i], nums2[j]));
             count++;

             if (j + 1 < nums2.length) {
                 pq.offer(new int[]{i, j + 1});
             }
         }
        return ans;


    }
}
