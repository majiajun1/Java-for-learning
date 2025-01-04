import java.util.ArrayDeque;
import java.util.Deque;

public class RainWater42 {
    public static void main(String[] args) { //单调栈！
        int[] rains= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(rains));
    }

     public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum=0;

        stack.push(0);
        for (int i = 1; i < height.length; i++) {


        while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
            int mid = height[stack.pop()];
           if(!stack.isEmpty()){
                    int h = Math.min(height[stack.peek()], height[i]) - mid;
                    int w = i-stack.peek()-1;
                    sum+=h * w;
                }


        }
        stack.push(i); // 当前索引入栈
    }

        return sum;
    }
}
