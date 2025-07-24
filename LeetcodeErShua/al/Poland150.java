/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;

public class Poland150 {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<tokens.length;i++)
        {
            String s = tokens[i];
            if(!s.equals("+")&&!s.equals("-")&&!s.equals("*")&&!s.equals("/"))
            {
                int i1 = Integer.parseInt(s);

                stack.push(i1);

            }else
            {
                if(s.equals("+"))
                {
                    stack.push(stack.pop()+stack.pop());
                }else if(s.equals("-"))
                {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left-right);
                }else if(s.equals("*"))
                {
                    stack.push(stack.pop()*stack.pop());
                }else if(s.equals("/"))
                {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left/right);
                }
            }

        }
        return stack.pop();
    }
}
