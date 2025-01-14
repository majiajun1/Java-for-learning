import java.util.*;

public class YiWeiCiGroup49 {
    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list=groupAnagrams(strs);
        for (List i:list)
        {
            System.out.println(i);
        }
    }
     public static List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> list = new ArrayList<>();
         HashMap<String, List<String>> map = new HashMap<>();

         int index = 0;
         for (String str : strs) {

             char[] charArray = str.toCharArray(); // 将字符串转换为字符数组
             Arrays.sort(charArray);              // 对字符数组进行排序

             // 将排序后的字符数组转换回字符串
             String temp = new String(charArray);
             if(!map.containsKey(temp))
             {
                 map.put(temp, new ArrayList<>());
                 List<String> tempList = map.get(temp);
                 tempList.add(str);
             }
             else
             {
                 map.get(temp).add(str);
             }


         }
         for (Map.Entry<String, List<String>> entry : map.entrySet()) {
             list.add(entry.getValue());
         }
         return list;
     }
}
