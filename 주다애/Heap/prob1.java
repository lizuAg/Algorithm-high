import java.util.*;

class Scoville {
    public static void main(String[] args) {
    }
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (Integer k : scoville) {
            q.offer(k);
        }

        while(q.size() > 1) {
            int first = q.poll();
            // 처음부터 q의 가장 작은 수가 K보다 크거나 같을 때
            if(first >= K) {
                return answer;
            }
            int second = q.poll();
            int res = first + (second * 2);
            answer++;
            q.offer(res);
            if(q.peek() >= K) {
                return answer;
            }
        }
        // 마지막으로 계산한 값이 K보다 크거나 같을 때도 성공한 것으로 침
        if(q.poll() >= K) {
            return answer;
        }
        return -1;
    }
}
