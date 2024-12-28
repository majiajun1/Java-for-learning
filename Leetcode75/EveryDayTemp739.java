import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class EveryDayTemp739 {
    public static void main(String[] args) {
        int[] temp={73,74,75,71,69,72,76,73};
        int[] ans=dailyTemperatures(temp);
        for(int i:ans)
        {
            System.out.println(i);
        }

    }


   public static int[] dailyTemperatures(int[] temperatures) {  // 单调栈
    int[] ans = new int[temperatures.length];
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < temperatures.length; i++) {
        while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
            int pop = stack.pop(); // 弹出栈顶索引
            ans[pop] = i - pop;    // 计算两天的差值
        }
        stack.push(i); // 当前索引入栈
    }

    return ans;
}







    public static int[] dailyTemperatures2(int[] temperatures) {  // 暴力解
        int[] ans=new int[temperatures.length];
        int right=0;
        for(int i=0;i<temperatures.length;i++) {
            int cur = temperatures[i];
            int day=0;
            for (int j = i + 1; j < temperatures.length; j++) {

                int now=temperatures[j];
                if(now>cur)
                {
                    day=j-i;
                    ans[i]=day;
                    break;
                }
                else ans[i]=0;
            }


        }



        return ans;
    }

}
