import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class SameStrutureString205 {
    public static void main(String[] args) {
        String s1 = "egg";
        String s2="add";
        System.out.println(isIsomorphic(s1, s2));

    }
    public static boolean isIsomorphic(String s, String t) {
         HashMap<Character, Character> map = new HashMap<>();
         HashMap<Character, Character> map2 = new HashMap<>();
         for (int i = 0; i < s.length(); i++) {
              if(!map.containsKey(s.charAt(i))){
                  map.put(s.charAt(i), t.charAt(i));
              }
              else
              {
                  if(map.get(s.charAt(i)) != t.charAt(i))
                      return false;
              }
              if(!map2.containsKey(t.charAt(i))){
                  map2.put(t.charAt(i), s.charAt(i));
              }else
              {
                  if (map2.get(t.charAt(i)) != s.charAt(i))
                      return false;
              }
         }


        return true;
    }
}
