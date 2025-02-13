import java.util.ArrayDeque;
import java.util.ArrayList;

public class MinStack {
     ArrayDeque<Integer> stack;
     ArrayList<Integer> minStack;

     public MinStack() {
         stack = new ArrayDeque<Integer>();
         minStack = new ArrayList<>();
     }

     public void push(int x) {
         stack.push(x);

         minStack.add(x);
         minStack.sort(Integer::compare);
     }

     public void pop() {
         int temp=stack.pop();
         minStack.remove(Integer.valueOf(temp));
     }

     public int top() {
         return stack.peek();
     }
     public int getMin() {
         return minStack.get(0);
     }




}
