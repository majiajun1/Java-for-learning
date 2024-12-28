import java.util.HashMap;
import java.util.*;

public class DuYiWuEr1207 {
    public static void main(String[] args) {
        int[] nums={1,2,2,1,1,3};
        boolean ans=uniqueOccurrences(nums);
        System.out.println(ans);
    }


    public static boolean uniqueOccurrences(int[] arr) {

        boolean ans=false;

        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        HashSet<Integer> set=new HashSet<>();

        for(int i:arr){
            map.put(i,map.getOrDefault(i, 0) + 1);
        }
        for(int i:map.values()){

            set.add(i);
        }
        if(set.size()<map.size()){
            return false;
        }
        else {
        return true;}
    }
}
