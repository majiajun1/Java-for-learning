import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinConverSubSeq76 {
    public static void main(String[] args) {
        String s="ab";
        String t="a";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) { //太慢了
        String ans="";
        int left=0,right=0;
        if(s.length()<t.length())
        {
            return "";
        }
        if (s.length() == t.length()&&s.length()==1)
        {
            if(s.charAt(0)==t.charAt(0))
            {
                return s;
            }
        }

        ArrayList<Integer> index=new ArrayList<>();
        HashSet<Character> set=new HashSet<>();
        for(char c:t.toCharArray()){
            set.add(c);
        }
        int len=t.length();

        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                index.add(i);
            }
        }
        if (index.size() < len) {
        return ""; // 如果字符不足，直接返回空
        }
        int index1=0;
        int index2=index1+len-1;

        HashMap<String,Integer> map=new HashMap<>();
        while(index2 < index.size()){
            left=index.get(index1);



            right=index.get(index2);
            while(checkSubseq(s,t,left,right)){




                String temp=s.substring(left,right+1);
                int templen=right-left+1;
                map.put(temp,templen);
                index1++;
                if(index1<index.size()){left=index.get(index1);}
                else{break;}


            }
            index2++;

        }

        int min=Integer.MAX_VALUE;

        if (map == null || map.isEmpty()) {
            return ""; // 空检查，返回 null 表示未找到
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue(); // 更新最小值
                ans = entry.getKey(); // 更新对应的键
            }
        }




        return ans;
    }
    public static boolean checkSubseq(String s, String t, int left, int right) {
        if (s == null || t == null || left < 0 || right >= s.length() || left > right) {
            return false; // 参数异常检查
        }

        // 使用 Map 存储 t 中字符的频次
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);  // 统计字符出现次数
        }

        // 遍历 s[left:right+1]，检查是否能满足 t 中字符的需求
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);  // 更新字符计数
            }
        }

        // 检查 map 中是否所有字符计数都为 0，意味着 t 中的所有字符都被匹配
        for (int count : map.values()) {
            if (count > 0) {
                return false; // 有未满足的字符需求
            }
        }

        return true; // 满足条件
        }




    public static String minWindow2(String s, String t) {
            String ans = "";
    int left = 0, right = 0;

    // 如果 s 长度小于 t 长度，直接返回空
    if (s.length() < t.length()) {
        return ans;
    }

    // 使用 Map 存储 t 中字符的频率
    Map<Character, Integer> tFreq = new HashMap<>();
    for (char c : t.toCharArray()) {
        tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
    }

    // 滑动窗口中的字符频率
    Map<Character, Integer> windowFreq = new HashMap<>();
    int required = tFreq.size();  // t 中不同字符的数量
    int formed = 0;  // 当前窗口内满足条件的字符数量

    int minLen = Integer.MAX_VALUE;

    // 使用滑动窗口来扫描 s
    while (right < s.length()) {
        char c = s.charAt(right);
        windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

        // 如果当前字符的频率满足 t 中的要求
        if (tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
            formed++;
        }

        // 一旦窗口包含所有字符，尝试收缩窗口，直到它不再满足条件
        while (left <= right && formed == required) {
            char leftChar = s.charAt(left);

            // 更新最小窗口
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                ans = s.substring(left, right + 1);
            }

            // 收缩左边界
            windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
            if (tFreq.containsKey(leftChar) && windowFreq.get(leftChar).intValue() < tFreq.get(leftChar).intValue()) {
                formed--;
            }

            left++;  // 左边界收缩
        }

        right++;  // 右边界扩展
    }

    return ans;



    }

















}
