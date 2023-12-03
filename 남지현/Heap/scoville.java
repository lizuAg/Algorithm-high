import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(queue::add);
        while(! allElementsGreaterThanK(queue, K) && queue.size() >= 2) {
            queue.add(mixScoville(queue.remove(), queue.remove()));
            count++;
        }
         return allElementsGreaterThanK(queue, K) ? count : -1;
    }
    
    private int mixScoville(int item1, int item2) {
        return item1 + item2 * 2;
    }
    
    private boolean allElementsGreaterThanK(PriorityQueue<Integer> queue, int K) {
        return queue.stream().noneMatch(element -> element < K);
    }
}
