public class YanZhengHuiWen125 {
    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }


     public static boolean isPalindrome(String s) {
        String s1=s.replaceAll("[^A-Za-z0-9]","");
        s1=s1.replaceAll(" ","");
        s1=s1.toLowerCase();
        int index=s1.length()-1;
         for (int i = 0; i <s1.length() ; i++) {
             if(s1.charAt(i)!=s1.charAt(index))
             {
                 return false;

             }

                 index--;

         }

        return true;
    }
}
