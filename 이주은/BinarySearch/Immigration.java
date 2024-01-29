//[프로그래머스] 입국심사 (https://school.programmers.co.kr/learn/courses/30/lessons/43238)

class Solution {
    public long solution(int n, int[] times) {
        long start = 1;
        long end = (long)times[0]*n;
        long mid;
        
        while(start <= end){
            mid = (start+end)/2;
            int people = 0;
            for(int time: times){
                //주어진 시간(mid) 동안 해당 심사관이 처리하는 사람 수
                people += mid/time;
                if(people >= n)
                    break;
            }
            if (people >= n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
