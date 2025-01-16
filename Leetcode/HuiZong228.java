import java.util.ArrayList;
import java.util.List;

public class HuiZong228 {
    public static void main(String[] args) {
        int[] nums={0,2,3,4,6,8,9};
        List<String> list=summaryRanges(nums);
        System.out.println(list);

    }
    public static List<String> summaryRanges(int[] nums) {
        int index1=0,index2=0;
        StringBuilder temp=new StringBuilder();
        List<String> list=new ArrayList<>();
        while(index2<nums.length){
             int qian=nums[index1];
             int hou=nums[index2];

             if(index2+1<=nums.length-1&& hou+1==nums[index2+1]){
                 index2++;
             }
             else{
                 temp.append(qian);
                 if(qian!=hou)
                 {temp.append("->");
                 temp.append(hou);
                 }

                 index1=index2+1;
                 index2=index1;
                 list.add(temp.toString());
                 temp=new StringBuilder();
             }
        }
        return list;
    }

}
