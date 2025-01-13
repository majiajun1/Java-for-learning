import java.util.HashMap;

public class ValidCharYiWei242 {
    public static void main(String[] args) {
         String str="anagram";
         String t="nagaram";
        System.out.println(isAnagram(str,t));
    }
     public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if(!map.containsKey(c))
            {
                return false;
            }
            else {
            map.put(c, map.getOrDefault(c, 0) - 1);}
        }
        for(int val : map.values())
        {
            if (val !=0)
            {
                return false;
            }
        }

        return true;
    }
}
