public class FindMidXia724 {
    public static void main(String[] args) {
        int[] input={2, 1, -1};
        int ans=pivotIndex(input);
        System.out.println(ans);
    }

     public static int pivotIndex(int[] nums) {
        int ans=-1;
        int total=0;
        int totalright=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }

        for(int i=nums.length-1; i>=0; i--){

            total=total-nums[i];
            if(total==totalright){
                ans=i;

            }
            totalright=totalright+nums[i];
        }

        return ans;
    }

}
