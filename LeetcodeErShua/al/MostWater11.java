/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.Arrays;

public class MostWater11 {
    public int maxArea(int[] height) {
        int ans=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int cur=Math.min(height[left],height[right])*(right-left);
            ans=Math.max(ans,cur);
            if(height[left]<height[right])
            {
                left++;
            }else
            {
                right--;
            }
        }


        return ans;
    }
}
