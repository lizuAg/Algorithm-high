import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (Character ch : chars) {
            if (ch.equals('('))
                stack.push(ch);
            else {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.size() <= 0;
    }
}
