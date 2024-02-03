//[프로그래머스] 징검다리 (https://school.programmers.co.kr/learn/courses/30/lessons/43236)

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int[] intervals = new int[rocks.length];
        
        int start = 1;
        int end = distance;
        int mid=0;
        
        while(start <= end) {
            mid = (start + end)/2;
            
            int cnt = 0, prev=0, interval;
            for(int i=0; i<rocks.length; i++){
                interval = rocks[i] - prev;
                if(interval <= mid){
                    cnt++;
                }else
                    prev = rocks[i];
            }
            //마지막 바위~도착지점
            if(distance - prev <= mid) cnt++;

            if(cnt > n)
                end = mid - 1;
            else
                start = mid + 1;
        }
        
        return start;
    }
}
