//[프로그래머스] 더 맵게(https://school.programmers.co.kr/learn/courses/30/lessons/42626)

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scov : scoville){
            pq.add(scov);
        }
        
        while(pq.peek() < K){
            if(pq.size() < 2)
                return -1;
            
            int scov1 = pq.poll();
            int scov2 = pq.poll();
            
            pq.add(scov1 + scov2*2);
            answer ++;
        }
        return answer;
    }
}
