// 사실 이게 순서 상으로는 prob2인데 마지막에 풀어서 prob3으로 했습니다!
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 소요시간으로 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // 요청시점으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        int count = 0;
        int prevEnd = 0;
        int sum = 0;
        int len = jobs.length;
        while(count < len || !queue.isEmpty()) {
            while(count < len && jobs[count][0] <= prevEnd) {
                queue.offer(jobs[count++]);
            }
            if(queue.isEmpty()) {
                prevEnd = jobs[count][0];
            } else {
                int[] temp = queue.poll();
                sum += temp[1] + prevEnd - temp[0];
                prevEnd += temp[1];
            }
        }
        return sum / len;
    }
}
