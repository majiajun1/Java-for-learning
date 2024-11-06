public class Fourth_Findthemiddle {
    public static void main(String[] args) {
        int[] nums1={1,2};
        int[] nums2={3,4};
        double ans=findMedianSortedArrays(nums1,nums2);
        System.out.println(ans);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {  //win 第一次击败100%
        int size1=nums1.length;
        int size2=nums2.length;

        int[] HeBing=new int[size1+size2];
        int middle1;
        int middle2;
        if((size1+size2)%2==0){
            middle1=(size1+size2)/2-1;
            middle2=middle1+1;
        }
        else{middle1=(size2+size1)/2;middle2=middle1;}
        int index1=0,index2=0;
        for(int i=0;i<size1+size2;i++){
            if(index1==size1){
                HeBing[i]=nums2[index2];
                index2++;
               continue;
            }
            if(index2==size2){
                HeBing[i]=nums1[index1];
                index1++;
                continue;
            }
            if(nums1[index1]<nums2[index2]){
                HeBing[i]=nums1[index1];
                index1=index1+1;
            }
            else
            {
                HeBing[i]=nums2[index2];
                index2=index2+1;
            }



        }
        return (double)(HeBing[middle1]+HeBing[middle2])/2.0;
    }
}
