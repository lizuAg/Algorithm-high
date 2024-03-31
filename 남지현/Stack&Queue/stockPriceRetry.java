import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
		int size = prices.length;
		int[] answer = new int[size];
		stack.push(0);
		for (int i=1; i<size; i++) {
			while(! stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int idx = stack.pop();
				if (answer[idx] == 0) {
					answer[idx] = i-idx;
				}
			}
			stack.push(i);
		}
		for (int i=0; i<size; i++) {
			if (answer[i] == 0) {
				answer[i] = size-i-1;
			}
		}
		return answer;
    }
}
