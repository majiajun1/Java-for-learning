import java.util.ArrayList;
import java.util.List;

public class ZuheTotal216 {


    public static void main(String[] args) {
        int k=9;
        int n=45;
        List<List<Integer>> list=combinationSum3(k,n);
        System.out.println(list);
    }



    public static List<List<Integer>> combinationSum3(int k, int n) {


        List<List<Integer>> combinations = new ArrayList<>();
        int sum=0;
        // 输入为空时直接返回空结果
        for(int i=1;i<k;i++){
            sum+=i;
        }
        if(sum>n)
        {
            return combinations;
        }
        List<Integer> currentTotal=new ArrayList<>();
        // 开始回溯
        backtrack(combinations
                                  , k,n, currentTotal,1,0);
        return combinations;
    }

    // 回溯方法
    private static void backtrack(List<List<Integer>> combinations
                                  ,int k,int n,List<Integer> currentTotal,int start,int total) {
        // 终止条件：已经处理完所有数字3

        if (total == n&&currentTotal.size() == k) {


            combinations.add(new ArrayList<>(currentTotal));
            return;
        }
        else if (currentTotal.size() > k  ||(total!=n&&currentTotal.size()==k)) {
            return;
        }

        // 获取当前数字对应的字母字符串

        // 遍历当前数字的每个字母
        for (int i = start; i <= 9; i++) {
            currentTotal.add(i); // 添加当前字母
            backtrack(combinations
                                  , k,n, currentTotal,i+1,total + i); // 处理下一个数字
            currentTotal.remove(currentTotal.size()-1); // 回溯，撤销选择
        }
    }
}
