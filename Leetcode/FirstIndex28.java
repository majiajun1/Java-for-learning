public class FirstIndex28 {
    public static void main(String[] args) {
        String str1="hello";
        String str2="ll";
        System.out.println(strStr(str1,str2));
    }

    public static int strStr(String haystack, String needle) {
        int index1=0;
        int index2=0;
        int firstone=0;
        while(index1<haystack.length()){
            firstone=index1;
            while(index1<haystack.length() && index2<needle.length()){
                if(haystack.charAt(index1)==needle.charAt(index2)){
                     if (index2 == 0) firstone = index1;
                    index1++;
                    index2++;
                    if (index2 == needle.length()) { // 完全匹配子字符串
                return firstone;
            }
                }
                else
                { // 如果字符不匹配
            if (index2 > 0) {
                // 回退到匹配起点的下一个位置
                index1 = firstone + 1;
            } else {
                index1++; // 继续向下检查
            }
            index2 = 0; // 重置子字符串索引
        }
                }




        }
        return -1;
    }
}
