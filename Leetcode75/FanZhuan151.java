import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FanZhuan151 {
    public static void main(String[] args) {

        String s="  hello world  ";
        String ans=reverseWords(s);
        System.out.println(ans);
    }


    public  static String reverseWords(String s) {

       LinkedList<String> q=new LinkedList<>();
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                temp.append(s.charAt(i));
            }
            else if(s.charAt(i)==' ')
            {
                if(temp.length()>0){
                q.addFirst(temp.toString());}
                temp.setLength(0);
            }
            if(i==s.length()-1&&s.charAt(i)!=' '){
                q.addFirst(temp.toString());
            }
        }
        temp.setLength(0);
        //System.out.println(q);
        while (!q.isEmpty()) {
            temp.append(q.removeFirst());
            if (!q.isEmpty()) {  // 在每个字符串之间加入空格
                temp.append(" ");
            }
        }
        //System.out.println(temp);
        return temp.toString();
    }

    public static String reverseWords2(String s) {  //更快 双指针倒着遍历
    int end = s.length() - 1;
    StringBuilder result = new StringBuilder();

    while (end >= 0) {
        // 跳过空格
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) break;

        // 找到单词的起始位置
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        // 添加单词到结果
        result.append(s.substring(start + 1, end + 1)).append(" ");
        end = start - 1;
    }

    // 去除最后一个多余的空格
    return result.toString().trim();
}
}
