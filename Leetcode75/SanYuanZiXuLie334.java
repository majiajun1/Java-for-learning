import java.util.ArrayList;
import java.util.Iterator;

public class SanYuanZiXuLie334 {
    public static void main(String[] args) {
        int[] input={2,1,5,0,3};
        boolean ans=increasingTriplet2(input);
        System.out.println(ans);


    }

    public static boolean increasingTriplet(int[] nums) { //太慢了
        if (nums.length < 3) {
            return false;
        }
        ArrayList<Integer> list=new ArrayList<>();

        int temp1=0;
        int temp2=0;
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            max=nums[i];
            list.clear();
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>max){
                    list.add(nums[j]);
                }
            }
            if(list.size()<2){list.clear();continue;}
            Iterator<Integer> ans=list.iterator();


            temp1 = ans.next();

            while (ans.hasNext()) {
                temp2 = ans.next();
                 if (temp1 < temp2) {
                    return true;
             }

        // 更新 temp1 为当前的 temp2 值，以便在下一次循环中使用
        temp1 = temp2;
    }
        }
        return false;
    }

     public static boolean increasingTriplet2(int[] nums) {  //更快
    if (nums.length < 3) {
        return false;
    }

    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    for (int num : nums) {
        if (num <= first) {
            first = num; // 更新最小的数
        } else if (num <= second) {
            second = num; // 更新第二小的数
        } else {
            // 找到一个数大于 first 和 second，即递增三元组
            return true;
        }
    }

    return false;
}
}
