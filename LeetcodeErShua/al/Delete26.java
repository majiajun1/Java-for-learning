/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

public class Delete26 {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        removeDuplicates(arr);
    }
    public static int removeDuplicates(int[] nums) {
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        int index1=0;
        int index2=1;
        while(index2<nums.length){
            if(temp[index1]!=nums[index2]){
                index1++;
                temp[index1] = nums[index2];
            }

            index2++;
        }
        for(int i=0; i<index1+1; i++){
            nums[i]=temp[i];
        }
        return index1+1;
    }
}
