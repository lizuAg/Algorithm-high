import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        for (int num: arr) {
            if (stack.empty()) {
                stack.push(num);
            } else {
                int status = stack.pop();
                if (status != num) 
                    stack.push(status);
                stack.push(num);
            }
        }
        while(!stack.empty()) {
            answer.add(stack.pop());
        }

        Collections.reverse(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
