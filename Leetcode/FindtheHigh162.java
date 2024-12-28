public class FindtheHigh162 {
    public static void main(String[] args) {

        int[] nums = {1,2,1,3,5,6,4};
        int target = findPeakElement(nums);
        System.out.println(target);
    }


    public static int findPeakElement(int[] nums) {
       int left = 0;//定义左边界
        int right = nums.length-1;//定义右边界

    while(left<right){
        int mid = (left+right)/2;
        if(nums[mid]<nums[mid+1]){
            left = mid+1;
        }else{
            right= mid;
        }
    }
    return left;
    }


}
