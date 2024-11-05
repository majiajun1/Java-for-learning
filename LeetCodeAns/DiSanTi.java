import java.util.*;

public class DiSanTi {
    public static void main(String[] args) {
        String a="dvdf";
        int ans=lengthOfLongestSubstring2(a);

        System.out.println(ans);
        System.out.println(a.charAt(2));

    }


    public static int lengthOfLongestSubstring(String s) { //滑动窗口法 最蠢的办法

        ArrayList<Character> sites= new ArrayList<Character>();
        for(char c: s.toCharArray()){
            sites.add(c);
        }

        ArrayList<Character> sites2= new ArrayList<Character>();
        ArrayList<Integer> ans= new ArrayList<Integer>();
        char temp;


        for(int i=0; i<sites.size(); i++) {
            List<Character> Chuangkou = sites.subList(i, sites.size());
            Iterator<Character> iter = Chuangkou.iterator();
            while (iter.hasNext()) {
                temp = iter.next();
                if (!sites2.contains(temp)) {
                    sites2.add(temp);
                } else {
                    ans.add(sites2.size());
                    sites2.clear();break;

                }
            }
        }
         ans.add(sites2.size());
         if(sites.isEmpty()){return 0;}
         return Collections.max(ans);

        }

        public static int lengthOfLongestSubstring2(String s) { //滑动窗口法  GPT优化版
           HashSet<Character> charSet = new HashSet<>();
        int left = 0; // 左指针
        int maxLength = 0; // 最大长度

        for (int right = 0; right < s.length(); right++) {
            // 如果当前字符已存在于集合中，移动左指针，直到移除重复字符
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            // 添加当前字符到集合
            charSet.add(s.charAt(right));
            // 计算当前窗口的长度并更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }



    }

