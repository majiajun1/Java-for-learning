import java.util.Scanner;

public class ZiJieChunZhao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n=in.nextInt();
        in.nextLine();
        String[] lines=new String[n];
        for(int i=0;i<n;i++)
        {
            lines[i]=in.nextLine();
        }

        for(String i:lines)
        {

            StringBuilder str=new StringBuilder();     //把第几对换成位置会不会更好呢？
//            for(int j=i.length()-1;j>=1;j--)
//            {
//                 if(i.charAt(j)!=i.charAt(j-1))
//                 {
//                     str.append(i.charAt(j));
//                     continue;
//                 }
//                 if(j-3>=2&&   i.charAt(j)==i.charAt(j-1)&&(i.charAt(j-2)!=i.charAt(j-3)))
//                 {
//                     continue;
//                 }
//
//                 if(j-2>=0&&  i.charAt(j)==i.charAt(j-1)&&(i.charAt(j-1)!=i.charAt(j-2)))
//                 {
//                     str.append(i.charAt(j));
//
//                 }else if(i.charAt(j-1)!=i.charAt(j-2))
//                 {
//                     continue;
//                 }
//
//
//
//

//            }
            str.append(i.charAt(0));
            str.reverse();
            System.out.println(str.toString());
            str=new StringBuilder();
        }
    }
}
