import java.util.Arrays;

public class FindMid4 {
    public static void main(String[] args) {
        int[] arr = {1,2};
        int[] arr2={3,4};
        findMedianSortedArrays(arr, arr2);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[] arr=new int[n1+n2];

//        System.arraycopy(nums1, 0, arr, 0, n1);
//        System.arraycopy(nums2, 0, arr, n1, n2);
//        Arrays.sort(arr);
        //key：自己排序合并

        int left=0,right=0;

        for(int i=0;i<(n1+n2)/2+1;i++){  //排到中位就好了
            if (left < n1 && (right >= n2 || nums1[left] < nums2[right])) {
                arr[i ] = nums1[left++];
            } else {
                        arr[i ] = nums2[right++];
            }


        }

     if((n1+n2)%2==0)
        {
            return (double) (arr[(n1+n2)/2]+arr[(n1+n2)/2-1])/2.0;
        }else
     {
         return (double) arr[(n1+n2)/2];
     }

    }
}
