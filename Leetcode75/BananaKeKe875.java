import java.util.Arrays;

public class BananaKeKe875 {
    public static void main(String[] args) {

        int[] piles={30,11,23,4,20};
        int h=5;
        System.out.println(minEatingSpeed(piles,h));

    }

    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        long sum=0;
        for(int i=0;i<piles.length;i++){
            sum+=piles[i];

        }
        long  temp=sum/h;

        long left=temp;
        long right=piles[piles.length-1];



       while(left<right){
        long mid = (left+right)/2;
        if(!Alleatable(piles,h,mid)){
            left = mid+1;
        }else{
            right= mid;
        }
      }
       return (int)left;

    }

    public static  boolean Alleatable(int[] piles, int H,long speed)
    {
        long h=0;
        for(int k:piles)
        {
            h+=(long) Math.ceil((double)k/speed);
        }
        return h<=H;
    }
}
