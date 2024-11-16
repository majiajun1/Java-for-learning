import java.util.Stack;

public class JieMa394 {
    public static void main(String[] args) {
        String s="100[leetcode]";
        String ans=decodeString(s);
        System.out.println(ans);

    }
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp=new StringBuilder();
        Stack<Character> c_stack = new Stack<Character>();
        Stack<Integer>   int_stack = new Stack<>();
        int tempbeishu=0;
        int shuziflag=0;
        int current=0;


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                current=current*10+Character.getNumericValue(c);

            }

            if(c!=']'&&!Character.isDigit(c)){
                c_stack.push(s.charAt(i));
                if(current!=0){
                int_stack.push(current);}
                current=0;

            }
            if(c==']'){
                tempbeishu=int_stack.pop();
                while (c_stack.peek()!='['){
                    temp.insert(0,c_stack.pop());
                }
                c_stack.pop();
                for(int k=0;k<tempbeishu;k++)
                {
                    for(char a:temp.toString().toCharArray())
                    {
                        c_stack.push(a);
                    }
                }
                temp.setLength(0);

            }
        }
        while (!c_stack.isEmpty()) {
            sb.append(c_stack.pop());  // 将栈顶元素添加到StringBuilder
        }
        return sb.reverse().toString();

    }
}
