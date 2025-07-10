/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

public class Total167 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left=0, right=numbers.length-1;
        while(left<right) {
            int sum = numbers[left] + numbers[right];
            if(sum>target) {
                right--;
            }else if(sum<target) {
                left++;
            }else
            {
                result[0] = ++left;
                result[1] = ++right;
                return result;
            }
        }
        return result;

    }
}
