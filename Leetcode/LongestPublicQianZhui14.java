public class LongestPublicQianZhui14 {
    public static void main(String[] args) {
        String[] str={"ab", "a"};
        System.out.println(longestCommonPrefix(str));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuffer prefix=new StringBuffer();

        for(int i=0;i<strs[0].length();i++) {

            prefix.append(strs[0].charAt(i));
            char a=prefix.charAt(i);
            for (int j = 0; j < strs.length; j++) {

                if (strs[j].length()<=i||a != strs[j].charAt(i) ) {

                    return prefix.toString().substring(0,i);
                }
            }

        }
        return prefix.toString();
    }
}
