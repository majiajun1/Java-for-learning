public class ZhongHua_605 {
    public static void main(String[] args) {
        int[] input={0};
        int n=0;
        boolean ans=canPlaceFlowers(input,n);
        System.out.println(ans);

    }


    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(flowerbed.length==1&&flowerbed[0]==0&&n==1||n==0){
            return true;
        }


        int count=0;
        for(int i=0;i<flowerbed.length;i++){
             if(i-1>-1&&i+1<flowerbed.length){
                 if(flowerbed[i]==0&&flowerbed[i+1]==0&&flowerbed[i-1]==0){
                     flowerbed[i]=1;
                     count++;

                 }

             }
             else if(i+1==flowerbed.length){
                 if(flowerbed[i]==0&&flowerbed[i-1]==0){
                     flowerbed[i]=1;
                     count++;
                 }

             }else {if(flowerbed[i]==0&&flowerbed[i+1]==0){flowerbed[i]=1;
                     count++;}}

        }
        return count>=n;
    }

}
