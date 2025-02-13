import java.util.ArrayDeque;

public class NiPolan150 {
    public static void main(String[] args) {
        String[] tokens={"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if(isNumber(token))
            {
                stack.push(Integer.parseInt(token));
            }else
            {
                if(token.equals("+"))
                {
                    int temp=0;
                    temp=temp+stack.pop();
                    temp=temp+stack.pop();
                    stack.push(temp);
                }
                if(token.equals("-"))
                {
                    int temp=0;
                    temp=temp-stack.pop();
                    temp=temp+stack.pop();
                    stack.push(temp);
                }
                if (token.equals("*"))
                {
                    int  temp=stack.pop();
                    temp=temp*stack.pop();
                    stack.push(temp);
                }
                if(token.equals("/"))
                {
                    int  temp=stack.pop();
                    temp=stack.pop()/temp;
                    stack.push(temp);
                }
            }
        }
        return stack.peek();

    }

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?"); // 支持负数和小数
    }
}
