import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SanShuTotal15 {
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> res=threeSum(nums);
        for(List<Integer> list:res){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res; // 如果数组为空或长度小于3，直接返回空结果
        }

        List<Integer> list=new ArrayList<>();
        int index1=0,index2=nums.length-1;
        int index3=0;
        int zeroindex=index3;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
            {
                index3=i;
                break;
            }
        }
        if(nums[index1]==0&&nums[index2]==0)
        {

            list.add(nums[index1]);
            list.add(nums[index2]);
            list.add(nums[index3]);
            res.add(list);
            list=new ArrayList<>();
            return res;
        }
        if(index3==0||index3==nums.length-1)
        {
            res.add(null);
            return res;
        }
        while(index1<index2){
            if(nums[index1]+nums[index2]+nums[index3]==0) {
                list.add(nums[index1]);
                list.add(nums[index2]);
                list.add(nums[index3]);
                res.add(list);
                list = new ArrayList<>();
                index3--;

            }
        }


        return res;
    }
}
