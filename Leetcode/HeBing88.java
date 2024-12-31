import java.util.Arrays;
import java.util.Collections;

public class HeBing88 {
    public static void main(String[] args) {
        int[]  nums1={1,2,3,0,0,0};
        int[]  nums2={2,5,6};
        int m=3;
        int n=3;
        merge(nums1,m,nums2,n);
        for(int i:nums1)
        {
            System.out.println(i);
        }
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 1 && n == 0) {
            return;
        }
        if (m == 0 && n == 1) {
            nums1[0] = nums2[0];
            return;
        }
        int index1 = 0;
        int index2 = 0;
        for (int i = m; i <m+n; i++) {
            nums1[i] = nums2[index2];
            index2++;
        }
        Arrays.sort(nums1);
    }
}
