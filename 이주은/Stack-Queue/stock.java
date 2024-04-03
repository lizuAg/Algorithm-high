//[프로그래머스] 주식가격(https://school.programmers.co.kr/learn/courses/30/lessons/42584)

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0; i<N; i++) {
            int curr = prices[i];
            while(!stack.isEmpty() && prices[stack.peekFirst()] > curr) {
                int idx = stack.removeFirst();
                
                answer[idx] = i-idx;
            }
            stack.addFirst(i);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.removeFirst();
            answer[idx] = N-idx-1;
        }
        return answer;
    }
}

