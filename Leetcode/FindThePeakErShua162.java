import java.util.ArrayDeque;

public class FindThePeakErShua162 {
//     public int findPeakElement(int[] nums) {
//         ArrayDeque<Integer> stack = new ArrayDeque<>();
//         stack.push(0);
//         for(int i = 1; i < nums.length; i++){
//             if(nums[i] > nums[stack.peek()]){
//                 stack.push(i);
//             }
//         }
//         return stack.peek();
//
//    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        int mid = (left + right)/2;
        while(left < right){
            mid = (left + right)/2;
            if(nums[mid] < nums[mid+1]){
                left = mid+1;
            }else
            {
                right = mid;
            }
        }
        return left;
    }

}
