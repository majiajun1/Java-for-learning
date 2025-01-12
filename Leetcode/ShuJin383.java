import java.util.HashMap;

public class ShuJin383 {
    public static void main(String[] args) {
        String str1="a";
        String str2="b";
        System.out.println(canConstruct(str1,str2));
    }


    public static boolean canConstruct(String ransomNote, String magazine) {
        boolean result = false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()) {
            if(map.containsKey(c)) {
                if(map.get(c) > 1) {
                    map.put(c, map.get(c) - 1);
                }
                else {
                    map.remove(c);
                }
            }else
            {
                return false;
            }


        }



        return true;
    }
}
