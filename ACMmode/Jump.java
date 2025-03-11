import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Jump {
      public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
         int n = in.nextInt();
         in.nextLine();
         Integer[] arr=new Integer[n];
         for (int i = 0; i < n; i++) {
             arr[i]=in.nextInt();
         }
          int E=0;
         for (int i =n-1;i>=0;i--){
             E=(E+arr[i]+1)/2;
         }


         System.out.println(E);



    }
}
