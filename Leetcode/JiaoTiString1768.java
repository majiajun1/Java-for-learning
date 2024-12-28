public class JiaoTiString1768 {
    public static void main(String[] args) {
        String a="ab";
        String b="pqrs";
        String ans=mergeAlternately(a,b);
        System.out.println(ans);
    }

    public static String mergeAlternately(String word1, String word2) {
            int index1=0;
            int index2=0;
            int len1=word1.length();
            int len2=word2.length();
            int lentotal=len1+len2;
            StringBuffer ans=new StringBuffer();
            while(index1<len1 || index2<len2){
                if(index1<len1&&index2<len2){
                ans.append(word1.charAt(index1++));
                ans.append(word2.charAt(index2++));
            }
                else if(index1>=len1){
                    ans.append(word2.charAt(index2++));
                }
                else if(index2>=len2){
                    ans.append(word1.charAt(index1++));
                }

            }
            return ans.toString();
    }
}
