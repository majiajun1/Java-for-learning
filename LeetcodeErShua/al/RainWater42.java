/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;

public class RainWater42 {
    public static void main(String[] args) {
        int[] arr={4,2,0,3,2,5};
        RainWater42 obj=new RainWater42();
        System.out.println(obj.trap(arr));
    }

    public int trap(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int water = 0;

        for (int curIndex = 0; curIndex < height.length; curIndex++) {
            // 跳过高度为0的柱子
            if (height[curIndex] == 0 && stack.isEmpty()) {
                continue;
            }

            // 当当前柱子高度大于栈顶柱子高度时
            while (!stack.isEmpty() && height[curIndex] > height[stack.peek()]) {
                int bottom = stack.pop();  // 底部柱子

                // 如果栈为空，说明没有左边界，无法积水
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();  // 左边界柱子
                // 计算积水高度和宽度
                int h = Math.min(height[left], height[curIndex]) - height[bottom];
                int w = curIndex - left - 1;
                water += h * w;
            }

            stack.push(curIndex);
        }

        return water;
    }
}
