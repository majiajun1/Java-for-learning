import java.util.HashMap;
import java.util.HashSet;

public class WordsGuiLv290 {
    public static void main(String[] args) {
         String pattern="abba";
         String s="dog cat cat dog";
        System.out.println(wordPattern(pattern,s));
    }
     public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length)
        {
            return false;
        }
         for (int i = 0; i < pattern.length(); i++) {
             if(map.containsKey(pattern.charAt(i))){
                  String temp = map.get(pattern.charAt(i));
                  if(!temp.equals(words[i])){
                      return false;
                  }


             }else {
             map.put(pattern.charAt(i), words[i]);}
             if(map2.containsKey(words[i]))
             {
                 Character temp = map2.get(words[i]);
                 if(!temp.equals(pattern.charAt(i))){
                     return false;
             }}else
             {
                 map2.put(words[i], pattern.charAt(i));
             }


         }


         return true;
    }
}
