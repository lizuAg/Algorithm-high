import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int len = prices.length;
        int[] answer = new int[len];
        for (int i=0; i<len; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            answer[stack.peek()] = prices.length-stack.peek()-1;
            stack.pop();
        }
        return answer;
    }
}
