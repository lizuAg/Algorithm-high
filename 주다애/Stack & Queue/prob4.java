import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{2, 1, 3, 2}, 0);
        System.out.println("result : " + result);
    }
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Process> q = new LinkedList<>();
        // 내림차순 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int len = priorities.length;
        for(int i = 0; i < len; i++) {
            // q에는 인덱스 같이 저장
            q.offer(new Process(i, priorities[i]));
            pq.offer(priorities[i]);
        }

        while(!pq.isEmpty()) {
            Process target = q.poll();
            if(target.getPr() == pq.peek()) {
                if(target.getLocation() == location) {
                    return answer;
                }
                answer++;
                pq.poll();
            }
            else {
                q.offer(target);
                /*
                여기서 pq.poll()하면 안되는 이유 --> q는 우선순위 별로 정렬되어 있지 않아서 더 큰 수가 뒤에 올 수 있다.
                즉, pq와 값을 비교해야 한다.
                */
                // pq.poll();
            }
        }
        return answer;
    }
}
class Process {
    int location;
    int pr;

    Process(int location, int pr) {
        this.location = location;
        this.pr = pr;
    }

    public int getLocation() {
        return this.location;
    }

    public int getPr() {
        return this.pr;
    }
}