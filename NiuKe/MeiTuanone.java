import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MeiTuanone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int l1=sc.nextInt();
        int r1=sc.nextInt();
        int l2=sc.nextInt();
        int r2=sc.nextInt();
        long ans=0;

        ans= cou(l1,r1,l2,r2);
        System.out.println(ans);
    }
    public  static int cou(int l1,int r1,int l2,int r2){
        return IntStream.rangeClosed(l2,r2).parallel()
                .map(b-> {
                    if (b == 0) {
                        return 0;
                    }

                    int kmin = (l1 + b - 1) / b;
                    int kmax = r1 / b;
                    return (kmin <= kmax) ? kmax - kmin + 1 : 0;
                }).sum();
    }
}
