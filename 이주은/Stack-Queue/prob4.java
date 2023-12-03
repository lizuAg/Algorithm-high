//[프로그래머스] 프로세스 (https://school.programmers.co.kr/learn/courses/30/lessons/42587)

import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int priority: priorities) {
            pq.add(priority);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location)
                        return answer + 1;
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
    }
}
