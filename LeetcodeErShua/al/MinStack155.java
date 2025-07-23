/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack155 {
    class MinStack {
        ArrayDeque<Integer> vals;    // 存储入栈的元素
        ArrayDeque<Integer> minVals; // 存储每一个元素入栈后的最小，即为一个单调栈，栈底自栈顶单调递减

        public MinStack() {
            vals = new ArrayDeque();
            minVals = new ArrayDeque();
        }

        public void push(int val) {
            vals.push(val);     // 元素入栈
            if(minVals.isEmpty()){
                minVals.push(val);  // 首个元素入栈，最小值为其本身
            }else{
                minVals.push(Math.min(val, minVals.peek())); // 否则更新当前栈内最小值，并入最小值栈
            }

        }

        public void pop() {
            minVals.pop();  // 弹出元素，那么这个元素入栈时对应的最小值也一并弹出
            vals.pop();  // 弹出元素
        }

        public int top() {
            return vals.peek(); // 返回元素栈栈顶值
        }

        public int getMin() {
            return minVals.peek();  // 返回最小值栈栈顶值
        }
    }

}
