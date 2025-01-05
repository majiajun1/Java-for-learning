public class LastWordLength58 {
    public static void main(String[] args) {
        String str="   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(str));

    }

    public static int lengthOfLastWord(String s) {
        int ans=0;
        int index=s.length()-1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                index--;


            }
            else
            {
                break;
            }

        }
        for(int i=index;i>=0;i--){
            if(s.charAt(i)==' '){
                break;


            }
            else
            {
                ans++;
            }

        }
        return ans;

    }
}
