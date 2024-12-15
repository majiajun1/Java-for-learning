import java.util.PriorityQueue;

public class HiringWorkers2462 {
    public static void main(String[] args) {
        int[]  costs={17,12,10,2,7,2,11,20,8};
        int k=3;
        int candidates=4;
        System.out.println(totalCost(costs,k,candidates));
    }




    public static long totalCost(int[] costs, int k, int candidates) { //用堆是不是慢了
       PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
       PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

       int n=costs.length;
       long totalCost=0;

       int left=0,right=n-1;

       while(left<=right&&left<candidates)
       {
           leftHeap.offer(costs[left]);
           left++;
       }
       while (right>=n-candidates&&right>=left)
       {

           rightHeap.offer(costs[right]);
           right--;
       }


        for (int i = 0; i < k; i++) {
            if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek() <= rightHeap.peek())) {
                totalCost += leftHeap.poll(); // 左堆出堆
                if (left <= right) { // 左堆可以继续加入人
                    leftHeap.offer(costs[left++]); //中间还有没参加的
                }
            } else {
                totalCost += rightHeap.poll(); // 右堆出堆
                if (left <= right) { // 右堆可以继续加入人
                    rightHeap.offer(costs[right--]); //中间还有
                }
            }
        }
        return totalCost;



    }
}
