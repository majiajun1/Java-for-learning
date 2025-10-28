//package hengsheng;
//
//import java.math.BigDecimal;
//import java.util.*;
//
//public class TITWO {
//     public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int n=in.nextInt();
//        long ans=in.nextLong();
//
//        int a=in.nextInt();
//        int b=in.nextInt();
//        int countOfGuess=0;
//        int countOfAsk=0;
//        in.nextLine();
//        for(int i=0;i<n;i++)
//        {
//            String thisLine=in.nextLine();
//            String[] line=thisLine.split(" ");
//            BigDecimal guess=new BigDecimal(line[1]);
//            if(line[0].equals("?"))
//            {
//                if(countOfAsk>=b)
//                {
//                    System.out.println("no");
//                    return;
//                }else
//                {
//                    countOfAsk++;
//
//                }
//            }else
//            {
//                 if(countOfGuess>=b)
//                {
//                    System.out.println("no");
//                    return;
//                }else
//                {
//                    countOfGuess++;
//                    if(guess==ans)
//                    {
//                        System.out.println("yes");
//                        return;
//                    }
//                }
//            }
//        }
//        System.out.println("no");
//
//    }
//}
