package MEIDI;

import java.util.Scanner;

public class ti3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=0;
        for (int i = 1; i <= n; i++) {
            int cur=i;
            while (cur!=0) {
                if(cur%10==1)
                {
                    count++;
                }
                cur=cur/10;
            }
        }
        System.out.println(count);
    }
}
