import java.util.Scanner;

public class TeGong {
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N=in.nextInt();
        int D=in.nextInt();
        in.nextLine();
        int[] B=new int[N];
        for(int i=0;i<N;i++)
        {
            B[i]=in.nextInt();
        }
        int left=0,mid=1,right=2;
        if(right>=N)
        {
            System.out.println(0);
        }
        int ans=0;



        System.out.println(ans%99997867);
    }
}
