import java.util.ArrayList;

public class L9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
     public static boolean isPalindrome(int x) {
         ArrayList<Integer> list = new ArrayList<>();
         if(x<0) return false;
         while(x!=0)
         {
             list.add(x%10);
             x/=10;
         }
         int l=0;
         int r=list.size()-1;
         while (l<r)
         {
             int tmp = list.get(l++);
             int tmp2 = list.get(r--);
             if(tmp==tmp2)
             {
                 continue;
             }else
             {
                 return false;
             }
         }
         return true;
    }
}
