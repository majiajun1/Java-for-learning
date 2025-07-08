/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

public class delete80 {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums) {
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        int index1=0;
        int index2=1;
        int count=0;
        while(index2<nums.length){
            if(temp[index1]!=nums[index2]){
                index1++;
                temp[index1] = nums[index2];
                count=0;
            }else{
                if(count<1)
                {
                    count++;
                    index1++;
                    temp[index1] = nums[index2];
                }
            }

            index2++;
        }
        for(int i=0; i<index1+1; i++){
            nums[i]=temp[i];
        }
        return index1+1;
    }
}
