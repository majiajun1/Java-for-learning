import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MaxSubseq2542 {
    public static void main(String[] args) {
        int[] nums1={1,3,3,2};
        int[] nums2={2,1,3,4};
        int k=3;
        long ans=maxScore(nums1,nums2,k);
        System.out.println(ans);

    }

   public static long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
		Integer[] index = new Integer[len];
        for(int i = 0; i < len; i++){
            index[i] = i;
        }
        Arrays.sort(index, (i, j) -> nums2[j] - nums2[i]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long ans = 0, sum = 0;
        for (int idx : index){
            int v1 = nums1[idx];
            int v2 = nums2[idx];

            while (minHeap.size() > k - 1){
                sum -= minHeap.remove();
            }

            minHeap.add(nums1[idx]);
            sum += nums1[idx];

            if(minHeap.size() == k){
                ans = Math.max(sum * v2, ans);
            }
        }
        return ans;
    }
    /*
    题目是要求  相加的和乘上最小值 找出最大的可能值
    乘数的权重要比和的权重高 所以优先找尽可能大的最小值乘数
    思想是按大往小排 找次/最小值  再按照index求出加和 乘尽可能大的最/次小值
    所以要用到堆（有点牵强）
     */

}
