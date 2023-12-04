import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int len = priorities.length;
        Arrays.stream(priorities).forEach(queue::add);
        while(!queue.isEmpty()) {
            for (int i=0; i<len; i++) {
                if (!queue.isEmpty() && priorities[i] == queue.peek()) {
                    queue.poll();
                    answer++;
                    if (i == location)
                        return answer;
                }
            }
        }
        return answer;
    }
}
