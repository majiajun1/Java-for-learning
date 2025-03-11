import java.util.ArrayList;
import java.util.*;

public class MaxThree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        boolean flag = false;
    StringBuilder sb=new StringBuilder();
    ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='-'){
                flag=true;
                continue;
            }
            if(s.charAt(i) != ','  ) {
                sb.append(s.charAt(i));

            }else{
                if(sb.length()!=0){
                    if(flag){
                list.add( (-1)*Integer.parseInt(sb.toString()));}else{
                    list.add(Integer.parseInt(sb.toString()));}

                    sb=new StringBuilder();
                }

                flag=false;



        }}
        if(sb.length()!=0) {
            if (flag) {
                list.add((-1) * Integer.parseInt(sb.toString()));
            } else {
                list.add(Integer.parseInt(sb.toString()));
            }
        }
       int[] nums= new int[list.size()];
        for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
        Arrays.sort(nums);
        int n=nums.length;
        System.out.println(Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]));
    }
}

