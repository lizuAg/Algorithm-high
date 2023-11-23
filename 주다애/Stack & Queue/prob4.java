import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 1, 3, 2};
        int answer = solution.solution(arr, 2);
        System.out.println("answer : "  + answer);
    }
    public int solution(int[] priorities, int location) {
        Queue<Proc> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 1;
        int len = priorities.length;

        for(int i = 0; i < len; i++) {
            q.offer(new Proc(priorities[i], i));
            pq.offer(priorities[i]);
        }

        while(!q.isEmpty()) {
            Proc target = q.poll();
            if(target.getPriority() >= pq.peek()) {
                if(target.getLocation() == location) {
                    return answer;
                }
                answer++;
                pq.poll();
            }
            else {
                q.offer(target);
            }
        }

        return answer;
    }
}
class Proc {
    int priority;
    int location;

    Proc(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getLocation() {
        return this.location;
    }
}
