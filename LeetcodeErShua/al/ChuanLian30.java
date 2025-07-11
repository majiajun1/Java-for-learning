/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChuanLian30 {
    public static void main(String[] args) {
        String s="wordgoodgoodgoodbestword";
        String[] words={"word","good","best","good"};
        for(Integer i:findSubstring(s,words))
        {
            System.out.println(i);
        }
    }
    public static List<Integer> findSubstring(String s, String[] words) { //滑动窗口
        HashMap<String,Integer> map = new HashMap<>();
        for(String w : words)
        {
            map.put(w,map.getOrDefault(w,0)+1);
        }
        List<Integer> res = new ArrayList<>();
        int len=words[0].length();
        int lenOfString=words.length*len;
        HashMap<String,Integer> map1=new HashMap<>();
        if(s.length()<lenOfString)
        {
            return res;
        }
        for(int i=0;i<lenOfString;i=i+len)
        {
            String cur=s.substring(i,i+len);
            map1.put(cur,map1.getOrDefault(cur,0)+1);  //初始化最前面的
        }
        if(map1.equals(map))
        {
            res.add(0);
        }
        int right=lenOfString+1;
        int left=1;
        while(right<=s.length())
        {

            map1=new HashMap<>();
            if(!map.containsKey(s.substring(left,left+len)))
            {
                left++;
                right++;
                continue;
            }

            String cur=s.substring(left,right);
            for(int i=0;i<lenOfString;i=i+len)
            {
                String curTemp=cur.substring(i,i+len);
                map1.put(curTemp,map1.getOrDefault(curTemp,0)+1);
            }


            if(map1.equals(map))
            {
                res.add(left);
            }
            left++;
            right++;
        }
        return res;
    }
}
