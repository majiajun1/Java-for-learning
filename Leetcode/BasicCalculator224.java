import javafx.scene.control.PopupControl;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BasicCalculator224 {
    public static void main(String[] args) {
        String s = "(5-(1+(5)))";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        ArrayDeque<String> stack=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        boolean Rest=false;
for (char c : s.toCharArray()) {
    if (c == ' ') {
        continue;
    }

//    if (c == ')') {
//        PopOutCalculate(stack);
//        continue;
//    }

    if (Character.isDigit(c)) {  // 直接判断是否为数字
        sb.append(c);
    } else if(c == ')')
    {
        if (sb.length() > 0) {  // 先把数字加入栈
            stack.addFirst(sb.toString());
            sb.setLength(0);
        }
          PopOutCalculate(stack);

    }
    else {  // 遇到运算符或者括号
        if (sb.length() > 0) {  // 先把数字加入栈
            stack.addFirst(sb.toString());
            sb.setLength(0);
        }
        stack.addFirst(String.valueOf(c));  // 这里仍然存为字符串，保证数据一致性
    }
}
        if(sb.length()>0){
                stack.addFirst(sb.toString());}
        ArrayList<String> list=new ArrayList<>();

        if(stack.size()==1)
        {
           return Integer.parseInt(stack.peek());
        }

        while (!stack.isEmpty()) //遍历完了 但是还要
        {
            Rest=true;

            list.add(0,stack.removeFirst());
        }

        if(Rest==true)
        {

            return Integer.parseInt(calculatethelist(list)) ;
        }else
        {
            return Integer.parseInt(stack.peek());
        }

    }




    public static void PopOutCalculate(ArrayDeque<String> stack)
    {
        ArrayList<String> list=new ArrayList<>();
        while (!stack.peek().equals("("))
        {
            if(stack.peek().equals(")"))
            {
                stack.removeFirst();
                continue;
            }else {
                list.add(0,stack.removeFirst());
            }
        }
        stack.removeFirst();
        stack.addFirst(calculatethelist(list));

    }



    public static String calculatethelist(ArrayList<String> list)
    {
        int curr=0;
        int opsindex=0;
        int right=0;
        if(!Character.isDigit(list.get(0).charAt(0)))
        {
            curr=0;
            opsindex=0;
            right=1;
        }else
        {
            curr=Integer.parseInt(list.get(0));
            opsindex=1;
            right=2;
        }



        while (right<list.size())
        {
            if(list.get(opsindex).equals("+"))
            {
                curr=curr+Integer.parseInt(list.get(right));
            }
            if (list.get(opsindex).equals("-"))
            {
                curr=curr-Integer.parseInt(list.get(right));
            }
            opsindex+=2;
            right+=2;
        }


        return  String.valueOf(curr);
    }


}
