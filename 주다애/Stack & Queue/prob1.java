import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        int len = arr.length;
        
        stack.push(arr[len-1]);
        
        for (int i = len - 2; i >= 0; i--) {
            if (stack.peek() == arr[i]) continue;
            stack.push(arr[i]);
        }
        
        int i = 0;
        int answer[] = new int[stack.size()];
        
        while(!stack.isEmpty()) {
            answer[i++] = stack.pop();
        }
        return answer;
    }
}
