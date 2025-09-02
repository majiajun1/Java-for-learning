package XHS2025;

import java.util.List;
import java.util.Scanner;

public class Tione {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=sc.nextInt();
        sc.nextLine();
        String str=sc.nextLine();
        for (int i = 1; i <=count; i++) {
            int ans=Deal(str,i);
            System.out.println(ans);
        }
    }

    public static int Deal(String str,int length){
        if(length==1)
        {
            return 0;
        }
        int countNotBao=0;
        String deal=str.substring(0,length);
        for(int i=0;i<length;i++)
        {
            int left=0;
            int right=left+i;
            while (right<deal.length())
            {
                String temp=deal.substring(left,right+1);
                if(temp.charAt(0)!=temp.charAt(temp.length()-1))
                {
                    countNotBao++;
                }
                left++;
                right++;
            }
        }



        return countNotBao;
    }
}
