import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class HappyNum202 {
    public static void main(String[] args) {
        int n=19;
        System.out.println(isHappy(n));
    }
    public static boolean isHappy(int n) {

        List<Integer> list=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();

        while(n!=1){
            list=new ArrayList<>();
            while(n!=0)
            {

                list.add(n%10);
                n=n/10;
            }
            for (int i=0;i<list.size();i++)
            {
                int temp=list.get(i);
                n=n+temp*temp;
            }

            if(set.contains(n))
            {
                return false;
            }else {set.add(n);}
        }
        return true;
    }
}
