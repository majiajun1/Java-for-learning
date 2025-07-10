/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeTotal15 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <3){
            return res;
        }


        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]>0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int cur = nums[i];

            int curIndex = i ;
            int left = curIndex+1;
            int right = nums.length - 1;



            while(left < right){
                if(nums[left] + nums[right] + cur == 0){


                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(right<left && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[left] + nums[right] + cur < 0)
                {
                    left++;

                }else
                {

                    right--;

                }
            }
        }
        return res;
    }
}
