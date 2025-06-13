/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package com;

public class Code189 {
    public static void main(String[] args) {

    }
    public void rotate(int[] nums, int k) {
        int RealRotate=k%nums.length;
        int[] temp=new int[nums.length];
        for (int i = 0; i < RealRotate; i++) {
           temp[i]= nums[nums.length-RealRotate+i] ;
        }
        int index=0;
        for (int i = RealRotate; i < nums.length; i++) {
            temp[i]=nums[index++];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i]=temp[i];
        }
    }
}
