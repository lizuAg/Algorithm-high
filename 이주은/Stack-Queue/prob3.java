//[프로그래머스] 올바른 괄호(https://school.programmers.co.kr/learn/courses/30/lessons/12909)
import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new LinkedList<>();
        
        for(int i=0; i<s.length(); i++){
            char bracket = s.charAt(i);
            if(bracket == '('){
                stack.addLast(bracket);
            }
            else{
                if(stack.isEmpty())
                    return false;
                stack.removeLast();
            }
        }
        return stack.isEmpty()? true : false;
    }
}
