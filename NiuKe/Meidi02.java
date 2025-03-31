import java.util.Scanner;

public class Meidi02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str=in.nextLine();
        char cur=str.charAt(0);
        int curnum=1;
        StringBuilder sb=new StringBuilder();

        for(int i=1;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch==cur)
            {
                curnum++;
            }else
            {
                sb.append(cur);
                if(curnum>1){sb.append(curnum);}

                cur=ch;
                curnum=1;
            }
        }
        if(curnum>1)
        {
            sb.append(cur);
            sb.append(curnum);
        }
        System.out.println(sb);
    }
}
