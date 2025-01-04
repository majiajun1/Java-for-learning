import java.util.HashMap;
import java.util.Map;

public class RomeNumberToInteger13 {
    public static void main(String[] args) {
        String s="III";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
       Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;

        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            res += map.get(c);
            if (i > 0) {
                char x = s.charAt(i-1);
                if (x == 'I' && (c == 'V' || c == 'X')) {
                    res-=2;
                }
                if (x == 'X' && (c == 'L' || c == 'C')) {
                    res-=20;
                }
                if (x == 'C' && (c == 'D' || c == 'M')) {
                    res-=200;
                }
            }
        }



        return res;

    }
}

