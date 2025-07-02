package com;/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */

import java.util.Arrays;

public class HeBing88 {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0};
        int m=0;
        int[] nums2={1,2,3,4,5};
        int n=5;
        merge(arr,m,nums2,n);
        for (int i : arr  ) {
            System.out.println(i);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(Math.min(m,n)==0)
        {
            if(m>n)
            {
                return;
            }else
            {
                for(int i=0;i<m+n;i++)
                {
                    nums1[i]=nums2[i];


                }
                 Arrays.sort(nums1);
                return;
            }
        }


            int index=m;
            int i=0;
            while(index<m+n)
            {
                nums1[index++]=nums2[i++];
            }
            Arrays.sort(nums1);
            return;

    }


}
