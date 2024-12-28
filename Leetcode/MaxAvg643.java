public class MaxAvg643 {
    public static void main(String[] args) {

        int[] input={5};
        int k=1;
        double ans=findMaxAverage2(input,k);
        System.out.println(ans);

    }

    public static double findMaxAverage(int[] nums, int k) {

        int index1=0;
        int index2=index1+k-1;

        double temp=0.0;
         for(int i=index1;i<=index2;i++){
                temp+=nums[i];
            }

         double max=temp/k;
        while(index2<(nums.length-1)){


            temp=temp-nums[index1];
            index1++;
            index2++;
            temp=temp+nums[index2];


           max=Math.max(max,temp/k);


        }
        return max;
    }


    public static double findMaxAverage2(int[] nums, int k) {  //优化version
        if(nums.length==1&&k==1) return nums[0];
        int index1=0;
        int index2=0;

        double temp=nums[0];
        double max=Double.NEGATIVE_INFINITY;
        while(index2<(nums.length-1)){
            if (index2 < k-1 ){

                index2++;
                temp=temp+nums[index2];
                max=temp/k;
                continue;}

            temp=temp-nums[index1++];

            temp=temp+nums[++index2];


           max=Math.max(max,temp/k);


        }
        return max;
    }
}
