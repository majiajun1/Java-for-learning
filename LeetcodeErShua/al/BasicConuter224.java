/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.time.temporal.ChronoField;
import java.util.ArrayDeque;

public class BasicConuter224 {
    public static void main(String[] args) {
        String s= "2-1 + 2";
        System.out.println(calculate(s));
    }

    //需要几个函数  进栈 出栈 然后处理区间的字符串
    public static int calculate(String s) {

        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder numTemp=new StringBuilder();
        for (Character token : s.toCharArray()) {
            if(token==' ')
            {
                continue;
            }
            if(token!=')')
            {
                if(token>='0'&&token<='9')
                {
                    numTemp.append(token);
                }else
                {
                    if(numTemp.length()>0)
                    {
                        stack.push(numTemp.toString());
                        numTemp=new StringBuilder();
                    }
                    stack.push(token.toString());
                }
            }else
            {
                if(numTemp.length()>0)
                {
                    stack.push(new String(numTemp));
                    numTemp=new StringBuilder();
                }
                while(!stack.isEmpty()&& !stack.peek().equals("("))
                {
                    sb.insert(0,stack.pop());
                    sb.insert(0," ");
                }
                stack.pop();
                stack.push(new String(String.valueOf(dealSeq(sb))));
                sb=new StringBuilder();
            }
        }
        if(numTemp.length()>0)
        {
            stack.push(numTemp.toString());
        }
        if(stack.size()>1)
        {
            sb=new StringBuilder();
            while(!stack.isEmpty())
            {
                sb.insert(0,stack.pop());
                sb.insert(0," ");
            }
            stack.push(new String(String.valueOf(dealSeq(sb))));
        }
        return Integer.parseInt(stack.pop());
    }

    public static int dealSeq(StringBuilder sb)
    {
        int curRes=0;

        String[] tokens = sb.toString().split(" ");
        int flag=0;

        for(int i=0;i<tokens.length;i++)
        {

            String s = tokens[i];
            if(s.equals(""))
                continue;
            if(s.equals("+"))
            {
                flag=1;
                continue;
            }else if(s.equals("-"))
            {
                flag=2;
                continue;
            }

            if(flag==0)
            {
                curRes=Integer.parseInt(s);
            }else if(flag==1)
            {
                curRes+=Integer.parseInt(s);
            }else if(flag==2)
            {
                curRes-=Integer.parseInt(s);
            }


        }
        return curRes;
    }
}
