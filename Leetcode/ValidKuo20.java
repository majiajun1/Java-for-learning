import java.util.ArrayDeque;
import java.util.Deque;

public class ValidKuo20 {
    public static void main(String[] args) {
        String s = "([])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);

            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if ((c == ')' && temp == '(') || (c == ']' && temp == '[' || c == '}' && temp == '{')) {


                } else return false;
            }

        }
        if (stack.isEmpty()) {
            return true;
        }else {
        return false;}

    }
}
