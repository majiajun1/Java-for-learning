/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class simpifly71 {
    public static void main(String[] args) {
        String s="/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(s));
    }
    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        List<String> list = new ArrayList<String>();
        for (String s : split) {
            if(s.length() == 0)
            {
                continue;
            }
            if(s.equals("."))
            {
                continue;
            }else if(s.equals(".."))
            {
                if(list.size() > 0) {
                    list.remove(list.size() - 1);
                }
            }else
            {
                list.add(s);
            }
        }
        StringBuffer sb = new StringBuffer();
        if(list.size() == 0)
        {
            return "/";
        }
        for(String s : list)
        {
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
  }
}
