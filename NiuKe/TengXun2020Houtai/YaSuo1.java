package TengXun2020Houtai;

import java.util.ArrayDeque;

public class YaSuo1 {
    public static void main(String[] args) {
        String str="HG[3|B[2|CA]]F";
        System.out.println(compress(str));
    }

    public static String compress (String str) {
        // write code here
       int index=0;
       ArrayDeque<Character> stack = new ArrayDeque<Character>();
       StringBuilder res = new StringBuilder();
       StringBuilder temp=new StringBuilder();

       while(index<str.length()){

           if(str.charAt(index)>='A' && str.charAt(index)<='Z' ) {

               stack.push(str.charAt(index++));


           }else
           {
               if(str.charAt(index)=='[')
               {
                   while(index<str.length()&&str.charAt(index)!=']'){
                       stack.push(str.charAt(index));
                       index++;
                   }
               }

               if(str.charAt(index)==']')
               {
                   StringBuilder cur=new StringBuilder();
                   while(stack.peek()!='[')
                   {
                       cur.insert(0, stack.pop());
                   }
                   stack.pop();
                  StringThink(cur,stack);


                   index++;
               }
           }
       }

       while(!stack.isEmpty())
       {
           res.insert(0,stack.pop());
       }
       return res.toString();
    }
    public static  void StringThink(StringBuilder str,ArrayDeque<Character> stack)
    {
        StringBuilder num=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        StringBuilder finalNum=new StringBuilder();
        for(char c:str.toString().toCharArray())
        {
            if(c>='0'&&c<='9')
            {
                num.append(c);
            }else if(c!='|')
            {
                temp.append(c);
            }
        }
        for(int i=0;i<Integer.parseInt(num.toString());i++)
        {
            finalNum.append(temp);
        }
        for(char c:finalNum.toString().toCharArray())
        {
            stack.push(c);
        }

    }

}
