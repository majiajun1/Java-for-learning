package Thunder;

import java.util.ArrayList;
import java.util.List;

public class TITWO {
    public static void main(String[] args) {
        int[] nums= {1,2,1,2,1};
        int k=3;
        for (int i:find_palindrome_subarrays(nums,k))
        {
            System.out.println(i);
        }
    }
    public static int[] find_palindrome_subarrays (int[] nums, int k) {
       List<Integer> indexList = new ArrayList<Integer>();
       StringBuilder stringBuilder=new StringBuilder();

       for(int i = 0; i < nums.length-k+1; i++){
           stringBuilder=new StringBuilder();
           for(int j=i;j<i+k;j++){
               stringBuilder.append(nums[j]);
           }
           if(Deal(stringBuilder))
           {
               indexList.add(i);
           }


       }
       return indexList.stream().mapToInt(i->i).toArray();
    }

    public static boolean Deal(StringBuilder stringBuilder) {
        int left = 0;
        int right = stringBuilder.length()-1;
        while(left < right) {
            if(stringBuilder.charAt(left) != stringBuilder.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
