import java.util.ArrayList;
import java.util.HashSet;
public class FanZhuan345 {
    public static void main(String[] args) {
        String s="IceCreAm";
        String ans=reverseVowels(s);
        System.out.println(ans);
    }

    public static String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        StringBuilder sb=new StringBuilder(s);
        StringBuilder temp=new StringBuilder();
        HashSet<Character> vowelslist = new HashSet<Character>();  //Hashset比arraylist更快  后者是o(n)
        for (char c : vowels.toCharArray()) {
            vowelslist.add(c);
        }
        int length = s.length();
        HashSet<Integer> index=new HashSet<>();

        for (int i = 0; i < length; i++) {
            if(vowelslist.contains(s.charAt(i))){
                temp.append(s.charAt(i));
                 index.add(i);

            }

        }
        int count = temp.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (vowelslist.contains(sb.charAt(i))) {
                sb.setCharAt(i, temp.charAt(count));
                count--;
            }
        }


        return sb.toString();

    }

    public static String reverseVowels2(String s) {  //我的版本更快
        String vowels = "aeiouAEIOU";
        StringBuilder sb=new StringBuilder(s);
        StringBuilder temp=new StringBuilder();
        HashSet<Character> vowelslist = new HashSet<Character>();  //Hashset比arraylist更快  后者是o(n)
        for (char c : vowels.toCharArray()) {
            vowelslist.add(c);
        }
        int length = s.length();
        HashSet<Integer> index=new HashSet<>();

        for (int i = 0; i < length; i++) {
            if(vowelslist.contains(s.charAt(i))){
                temp.append(s.charAt(i));
                 index.add(i);

            }

        }
        int count = temp.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (vowelslist.contains(sb.charAt(i))) {
                sb.setCharAt(i, temp.charAt(count));
                count--;
            }
        }


        return sb.toString();

    }
}
