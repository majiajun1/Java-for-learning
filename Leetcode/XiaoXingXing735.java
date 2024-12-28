import java.util.*;

public class XiaoXingXing735 {
    public static void main(String[] args) {
            int[] input={-2,-2,1,-2};
            int[] ans=asteroidCollision(input);
            System.out.println(ans);

    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();



         for (int asteroid : asteroids) {
            // 当前小行星是否需要入栈
            boolean isSafe = true;

            // 如果栈不为空，且栈顶元素为正值，当前小行星为负值，可能发生碰撞
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();
                if (Math.abs(asteroid) > Math.abs(top)) {
                    stack.pop(); // 栈顶小行星爆炸
                } else if (Math.abs(asteroid) == Math.abs(top)) {
                    stack.pop(); // 两者大小相同，双方爆炸
                    isSafe = false; // 当前小行星不入栈
                    break;
                } else {
                    isSafe = false; // 当前小行星爆炸
                    break;
                }
            }

            // 如果当前小行星没有爆炸，入栈
            if (isSafe) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }


        public static int[] asteroidCollision2(int[] asteroids) {
         List<Integer> result = new ArrayList<>();

        for (int asteroid : asteroids) {
            boolean isSafe = true;

            // 处理碰撞: 如果栈内的行星是向右移动且当前小行星是向左的
            while (!result.isEmpty() && result.get(result.size() - 1) > 0 && asteroid < 0) {
                int top = result.get(result.size() - 1);
                if (Math.abs(asteroid) > Math.abs(top)) {
                    result.remove(result.size() - 1);  // 当前小行星撞碎栈顶的小行星
                } else if (Math.abs(asteroid) == Math.abs(top)) {
                    result.remove(result.size() - 1);  // 双方爆炸
                    isSafe = false;  // 当前小行星被摧毁
                    break;
                } else {
                    isSafe = false;  // 当前小行星被摧毁
                    break;
                }
            }

            // 如果当前小行星没有摧毁，放入结果列表
            if (isSafe) {
                result.add(asteroid);
            }
        }

        // 将结果转换为数组并返回
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}
