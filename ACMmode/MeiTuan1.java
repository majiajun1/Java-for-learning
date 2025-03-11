//import java.util.*;
//public class MeiTuan1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//         long Total=in.nextInt();
//         in.nextLine();
//         long p=0;
//         ArrayList<String> list=new ArrayList<>();
//         for(long i=0;i<Total;i++){
//            list.add(in.nextLine());
//         }
//         for(String s:list){
//             StringBuilder str3=new StringBuilder();
//         for(char ch:s.toCharArray()){
//              if((ch>='0' && ch<='9')){
//                  if(p==0)
//                  {
//                      p=ch-'0';
//                  }else
//                  {
//                      p=p*10+(ch-'0');
//                  }
//              }else {
//
//                  if(p!=0)
//                  {
//                      str3=Yiwei(p,str3);
//                      p=0;
//                      str3.append(ch);
//                  }else
//                  {
//                      if(ch!='R')
//                      {
//                          str3.append(ch);
//                      }else
//                      {
//                          str3.reverse();
//                      }
//                  }
//
//
//              }
//         }
//             System.out.println(str3.toString());
//         }
//
//
//    }
////    public static StringBuilder Yiwei(long index,StringBuilder str)
////    {
////        StringBuilder str2=new StringBuilder();
////        long n=index%str.length();
////        if(n==0)
////        {
////            return str;
////        }
////        for(long i=n;i<str.length();i++)
////        {
////            str2.append(str.charAt(i));
////        }
////        for(long j=0;j<n;j++)
////        {
////            str2.append(str.charAt(j));
////        }
////        return str2;
////    }
//
//}
