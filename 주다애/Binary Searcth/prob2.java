import java.util.*;

// 징검다리
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 정렬
        Arrays.sort(rocks);
        
        int len = rocks.length;
        int min = 0; 
        int max = distance; 
        int answer = 0;

        while(min <= max) {
            int mid = (min + max) / 2; 
            int prev = 0; // 이전 돌의 위치
            int remove = 0; // 제거한 돌의 개수

            for(int i = 0; i < len; i++) {
                // 현재 돌과 이전 돌 사이의 거리가 mid보다 작으면 돌 제거
                if(rocks[i] - prev < mid) {
                    remove++;
                } else {
                    prev = rocks[i]; // 이전 돌의 위치를 현재 돌로 업데이트
                }
            }

            // 마지막 돌 체크
            if(distance - prev < mid) remove++;

            // 제거한 돌의 개수가 n보다 큼
            if(remove > n) {
                max = mid - 1;
            } 
            // 제거한 돌의 개수가 n보다 작거나 같음
            else { 
                min = mid + 1;
                answer = Math.max(answer, mid);
            }
        }  
        return answer;
    }
}
