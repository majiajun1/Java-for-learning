import java.util.Stack;

public class RemoveStar2390 {
    public static void main(String[] args) {
        String s="leet**cod*e";
        String ans=removeStars2(s);
        System.out.println(ans);


    }

    public static String removeStars(String s) { //慢了
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                st.pop();
            }
            else
            {
                st.push(s.charAt(i));
            }
        }
        char[] c=new char[st.size()];
        for(int i=c.length-1;i>=0;i--)
        {
            c[i]=st.pop();
        }
        return new String(c);
    }

    public static String removeStars2(String s){
        int star=0;
        StringBuilder sb=new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i)=='*'){
                star++;
            }
            else if(s.charAt(i)!='*'&&star!=0){
                star--;

            }
            else if (s.charAt(i)!='*'&&star==0)
            {
                sb.append(s.charAt(i));
            }
        }



        return sb.reverse().toString();
    }
}
