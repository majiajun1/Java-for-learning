import java.util.Random;

public class GuessBigSmall374 {
    public static void main(String[] args) {



    }
    public static int guessNumber(int n) {

Random rand=new Random();
        int pick=rand.nextInt(n);
      int min = 1;
          int max = n;

          while (min <= max) {
              int mid =min+(max-min)/2;
              int temp=guess(mid,pick);
              if (temp == 1) {
                  min=mid+1;
              } else if (temp ==-1) {
                  max=mid-1;
              }
              else return mid;

          }
          return  min;
      }

      public static int guess(int n,int pick) {

             if(pick==n) return 0;
             else if(pick>n) return 1;
             else return -1;
      }


}
