import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SimplifyRoot71 {
    public static void main(String[] args) {
        String s="/...";
        System.out.println(simplifyPath(s));
    }
     public static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<String>();

        for(char c:path.toCharArray()){
            if(c=='/') {
                if (sb.length() > 0) {
                    if (sb.toString().equals("..")) {
                        if(list.size() > 0) {list.remove(list.size() - 1);}

                        sb.setLength(0);
                        continue;
                    }
                    if (sb.toString().equals(".")) {
                        sb.setLength(0);
                        continue;
                    }
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            }
            else
            {
                sb.append(c);

            }

        }

        if (sb.length() >0) {
            if (sb.toString().equals(".."))
                {if(list.size() > 0)
            {
                list.remove(list.size() - 1);}

            }else if(!sb.toString().equals(".")){
            list.add(sb.toString());}
        }
        if(list.size()==0)
            {
                return "/";
            }
        sb.setLength(0);
            for(String a:list)
            {
                sb.append("/");
                sb.append(a);
            }


        return sb.toString();
     }


}
