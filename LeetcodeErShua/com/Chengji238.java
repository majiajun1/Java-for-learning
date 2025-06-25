/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package com;

public class Chengji238 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] arr2=productExceptSelf(arr);
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int total=1;
        int zero=0;
        for (int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                zero++;
            }else
            {
                total*=nums[i];
            }

        }
        int[] res = new int[n];
        for (int i=0;i<n;i++)
        {
            if(nums[i]==0&&zero==1)
            {
                res[i]=total;
            }else if(zero>=2&&(nums[i]!=0&&zero==1))
            {
                res[i]=0;
            }else if(zero==0){
            res[i]=total/nums[i];
            }
        }
        return res;
    }
}
