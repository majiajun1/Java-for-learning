package YuXin;
import  java.util.*;
public class TIONE {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n=in.nextInt();
        for(int i=0;i<n;i++)
        {
            int st=in.nextInt();
            int en=in.nextInt();
            int t=in.nextInt();
            System.out.println(Deal(st,en,t));
        }
    }

    public static double Deal(int st,int en,int t)
    {
        if(t<=st)
        {
            return 0.0;
        }

        if(t>=en)
        {
            return 1/   .0;
        }

        return  (double) (t-st)/(en-st);


    }
}
