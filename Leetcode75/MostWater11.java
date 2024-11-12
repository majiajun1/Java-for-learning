public class MostWater11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int ans=maxArea(height);
        int ans2=maxArea2(height);
        System.out.println(ans);
        System.out.println(ans2);
    }
     public static int maxArea(int[] height) { //最蠢方法
        int MaxWaterAns=0;
        int small=Integer.MAX_VALUE;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
               small=Math.min(height[i],height[j]);
               if((small*(j-i))>MaxWaterAns)
               {
                   MaxWaterAns=small*(j-i);
               }
            }
        }
        return MaxWaterAns;


    }
    public static int maxArea2(int[] height) { //双指针
         int start=0,end=height.length-1;
         int ans=Integer.MIN_VALUE;
         while(start!=end){
             int s=Math.min(height[start],height[end])*(end-start);
             ans=Math.max(ans,s);
             if(height[start]<=height[end])
             {
                 start++;
             }else
             {
                 end--;
             }

         }

     return ans;
    }

}
