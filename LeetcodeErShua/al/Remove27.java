/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

public class Remove27 {
    public static void main(String[] args) {

    }
    public int removeElement(int[] nums, int val) {
         int[] temp = new int[nums.length];
         int index = 0;
         for (int i = 0; i < nums.length; i++) {
             if (nums[i] != val) {
                 temp[index++] = nums[i];
             }
         }
         for (int i = 0; i < index; i++) {
             nums[i] = temp[i];
         }
         return index;
    }
}
