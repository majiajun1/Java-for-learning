



public class GuessBigSmall374 {
    public static void main(String[] args) {



    }
    public static int guessNumber(int n) {

      int min = 1;
          int max = n;
          while (min < max) {
              int mid = min + (max - min) / 2;
              if (guess(mid) == 1) {
                  min=mid+1;
              } else if (guess(mid) <=0) {
                  max=mid;
              }
          }
          return  min;
      }


}
