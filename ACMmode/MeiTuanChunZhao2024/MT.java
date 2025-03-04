package MeiTuanChunZhao2024;

import java.util.Scanner;

public class MT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        String str=sc.nextLine();

        int sum=0;
        for(char c:str.toCharArray()){
            if(c=='M'||c=='T')
            {
                sum++;
            }
        }
        int notCount=N-sum;
        if(sum==N)
        {
            System.out.println(sum);
        }
        else {
           if(notCount>=k)
           {
               System.out.println(sum+k);
           }else
           {
               System.out.println(N);
           }
        }


        sc.close();
    }
}
