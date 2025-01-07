public class PanDuan392 {
    public static void main(String[] args) {
        String s="b";
        String t="abc";
        boolean ans=isSubsequence(s,t);
        System.out.println(ans);

    }
    public static boolean isSubsequence(String s, String t) {

        if(s.length()==0)
        {
            return true;
        }
        if(t.length()==0)
        {
            return false;
        }

        int index=0;

        for (char c : t.toCharArray()) {
            if(c==s.charAt(index))
            {
                index++;
            }
            if(index==s.length())
            {
                return true;
            }
        }

        return false;



    }



}
