package TongDun;

public class TiOne {
    public static void main(String[] args) {
        String[] strs= {"aaa","aab","aac"};
        System.out.println(longestPrefix(strs));
    }


    public static String longestPrefix (String[] strs) {
        StringBuilder prefix=new StringBuilder(strs[0]);
        for(String str:strs)
        {
            int n=str.length();
            int m=prefix.length();
            int maxIndex=n>m?m:n;
            int index=0;
            while(index<maxIndex&&str.charAt(index)==prefix.charAt(index))
            {
                index++;
            }
            prefix=new StringBuilder( prefix.toString().substring(0,index));
        }
        return prefix.toString();
    }
}
