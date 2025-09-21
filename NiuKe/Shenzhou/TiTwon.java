package Shenzhou;
import java.util.*;

public class TiTwon {
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int nums=in.nextInt();
        in.nextLine();
        for(int i=0;i<nums;i++)
        {

            String S=in.nextLine();
            String T=in.nextLine();

            System.out.println(Deal(S,T));
        }
    }

    public static String Deal(String s,String t)
    {
        if(s.length()!=t.length())
        {
            return new String ("No");
        }
        if(s.equals(t))
        {
            return "Yes";
        }
        StringBuilder newS=new StringBuilder(s);
        for(int i=0;i<s.length();i++)
        {
            char last=newS.charAt(newS.length()-1);
            newS.deleteCharAt(newS.length()-1);
            newS.insert(0,last);
            if(newS.toString().equals(t))
            {
                return "Yes";
            }

        }

        return new String("No");

    }
}
