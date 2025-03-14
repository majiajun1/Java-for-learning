package MeiTuanChunZhao2024;

import java.util.Scanner;

public class ShuZuQuery {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MatrixLength = sc.nextInt();
        int QueryTimes=sc.nextInt();

        sc.nextLine();
        long  sum=0;
        long zerocount=0;
        for (int i = 0; i < MatrixLength; i++) {
            long temp=sc. nextLong();
            if(temp!=0){
                sum+=temp;
            }else
            {
                zerocount++;
            }
        }
        StringBuilder output = new StringBuilder();
        for (int j = 0; j < QueryTimes; j++) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            output.append(sum + zerocount * a).append(" ")
                  .append(sum + zerocount * b).append("\n");
        }

        // 一次性输出
        System.out.print(output);
        sc.close();
    }
}
