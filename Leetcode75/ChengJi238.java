public class ChengJi238 {
    public static void main(String[] args) {
        int[] input={-1,1,0,-3,3};
        int[] ans=productExceptSelf(input);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }

    }

    public static int[] productExceptSelf(int[] nums) {
        int[] ans=new int[nums.length];
        int temp=1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(j!=i){
                temp=temp*nums[j];}
            }
            ans[i]=temp;
            temp=1;
        }


        return ans;
    }
       public static int[] productExceptSelf2(int[] nums) {//在 O(n) 时间复杂度内完成此题。
        int n=nums.length;
        int[] ans = new int[n];
        ans[0]=1; //第一个元素的左边没有数
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];   //前缀乘积
        }
        int R=1;  //最后一个元素的右边没有数
        for(int i=n-1;i>=0;i--){
            ans[i]=ans[i]*R;      //最终的结果=前缀乘积×后缀乘积
            R=nums[i]*R;   //更新后缀乘积
        }
        return ans;
    }



}
