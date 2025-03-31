import java.util.Scanner;

public class meituannew {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        long l1=sc.nextLong();
        long r1=sc.nextLong();
        long l2=sc.nextLong();
        long r2=sc.nextLong();
        long ans=0;

        for(long i=l2;i<=r2;i++)
        {

            if(i==1)
            {
                ans+=r1-l1+1;
                continue;
            }


            long temp=(l1+1)/i; //kmin
            long temp2=r1/i; //kmax
            ans+=temp2-temp+1;






        }
        System.out.println(ans);
    }
}
