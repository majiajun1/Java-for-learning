package al;

public class FindFirst28 {
    public static void main(String[] args) {
        String s1="abc";
        String s2="c";
        System.out.println(strStr(s1,s2));
    }
     public static int strStr(String haystack, String needle) {
        int left = 0, right = needle.length();
        int index=0;
        if(needle.length()==haystack.length()&&needle.equals(haystack)){
            return index;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }
        while (right+index <= haystack.length()) {
            String sub=haystack.substring(left+index, right+index);
            if (sub.equals(needle)) {
                return left+index;
            }
            index++;
        }
        return -1;
    }
}
