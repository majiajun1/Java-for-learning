public class FindRoundMin153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {  //正常情况下右边都比左边大  如果不是  最右边小于mid
                                                // 低点在mid和right之间

                left = mid + 1;
            }else
            {
                right = mid;

            }
        }
        return nums[left];
    }
}
