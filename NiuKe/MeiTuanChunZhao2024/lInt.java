package MeiTuanChunZhao2024;

import java.util.ArrayList;

public class lInt {

    public static void main(String[] args) {
        String example="-12 - 344-4";
        System.out.println(StringToInt(example));
    }


        public static int  StringToInt(String str)
    {
        ArrayList<Character> chars = new ArrayList<Character>();
        boolean flag = false;
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(c=='-'&&i==0)
            {
                flag = true;
            }

            if(c>='0'&&c<='9')
            {
                chars.add(c);
            }
        }
        int ans=0;
        int Jinwei=0;
        for(int i=chars.size()-1;i>=0;i--)
        {
               int Ten=1;
               for(int j=0;j<Jinwei;j++)

               {
                   Ten=Ten*10;
               }
                ans=ans+ (chars.get(i)-'0')*Ten;
                Jinwei++;
        }
        if(flag)
        {
            return ans*(-1);
        }else
        {
             return ans;
        }

    }
}
