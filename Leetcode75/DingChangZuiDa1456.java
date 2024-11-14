import java.util.*;

public class DingChangZuiDa1456 {
    public static void main(String[] args) {
        String s="tryhard";
        int k=4;
        int ans=maxVowels(s,k);
        System.out.println(ans);
    }
    public static int maxVowels(String s, int k) { //遍历版


        HashSet<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int max=0;
        int temp=0;
        int left=0;
        for (int i = 0; i < k; i++) {
        if (set.contains(s.charAt(i))) {
            temp++;
        }
     }
        max = temp;
        for(int i=k;i<s.length();i++){


            left=i-k;
            if(set.contains(s.charAt(left)))
            {
                temp--;
            }

            if(set.contains(s.charAt(i)))
                {temp++;}

            if(temp>max)
            {
                max=temp;
            }
        }
        return max;
    }
    public static int maxVowels2(String s, int k) { //不用hashset



        int max=0;
        int temp=0;
        int left=0;
        for (int i = 0; i < k; i++) {
        if ((s.charAt(i))=='a'||(s.charAt(i))=='e'||(s.charAt(i))=='i'||(s.charAt(i))=='o'||(s.charAt(i))=='u') {
            temp++;
        }
     }
        max = temp;
        for(int i=k;i<s.length();i++){


            left=i-k;
            if((s.charAt(left))=='a'||(s.charAt(left))=='e'||(s.charAt(left))=='i'||(s.charAt(left))=='o'||(s.charAt(left))=='u')
            {
                temp--;
            }

            if((s.charAt(i))=='a'||(s.charAt(i))=='e'||(s.charAt(i))=='i'||(s.charAt(i))=='o'||(s.charAt(i))=='u')
                {temp++;}

            if(temp>max)
            {
                max=temp;
            }
        }
        return max;
    }
}
