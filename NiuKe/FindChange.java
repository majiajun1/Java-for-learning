import java.util.Scanner;

public class FindChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int ans=0;
       int n=in.nextInt();
       int sheng=1024-n;
        ans=ans+sheng/64;
        sheng=sheng%64;
        ans=ans+sheng/16;
        sheng=sheng%16;
        ans=ans+sheng/4;
        sheng=sheng%4;
        ans=ans+sheng/1;
        System.out.println(ans);
    }
}

