import java.util.ArrayList;

public class YaSuo443 {
    public static void main(String[] args) {
        char[] input={'a'};
        int ans=compress(input);
        System.out.println(ans);

    }

    public static int compress(char[] chars) {   //leetcode有BUG 忽略

        char temp=chars[0];
        int tempcount=0;
        ArrayList<Character> al=new ArrayList<>();
        al.add(temp);
        for(char i:chars){
            if(i==temp)
            {
                tempcount++;
            }
            else  {
                al.add((char)(tempcount));
                tempcount=1;
                al.add(i);
                temp=i;
            }

        }
        al.add((char)(tempcount));

        return al.size();
    }
}
