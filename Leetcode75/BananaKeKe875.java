import java.util.Arrays;

public class BananaKeKe875 {
    public static void main(String[] args) {

        int[] piles={30,11,23,4,20};
        int h=5;
        System.out.println(minEatingSpeed(piles,h));

    }

    public static int minEatingSpeed(int[] piles, int h) {
//        Arrays.sort(piles);
//        long sum=0;
//        for(int i=0;i<piles.length;i++){
//            sum+=piles[i];
//
//        }
//        long  temp=sum/h;

        long left=1;
        long right=Integer.MAX_VALUE;



       while(left<right){
        long mid = (left+right)/2;
        long time=Alleatable(piles,h,mid); //先赋值再判断 速度更快
        if(time>h){
            left = mid+1;
        }else{
            right= mid;
        }
      }
       return (int)left;

    }

    public static  long Alleatable(int[] piles, int H,long speed)
    {
        long h=0;
        for(int k:piles)
        {
            h+=  (k+speed-1)/speed; //Math.ceil库速度太慢了
        }
        return h;
    }
}
