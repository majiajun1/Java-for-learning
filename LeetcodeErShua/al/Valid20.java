/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;
import java.util.Stack;

public class Valid20 {
    public boolean isValid(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }else if(stack.peek() == '(')
                {
                    if(c==')')
                    {
                        stack.pop();
                    }else
                    {
                        return false;
                    }
                }else if (stack.peek() == '{') {
                    if(c=='}')
                    {
                        stack.pop();
                    }else
                    {
                        return false;
                    }
                }else if (stack.peek() == '[') {
                    if(c==']')
                    {
                        stack.pop();
                    }else{
                        return false;
                    }
                }

            }
        }
        return stack.isEmpty();

    }

}
