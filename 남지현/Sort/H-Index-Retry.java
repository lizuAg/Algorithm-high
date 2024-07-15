import java.util.*;

// 프로그래머스 lv2 - H-Index (처음 시도한 풀이)

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        for (int idx=citations[n-1]; idx>=0; idx--) {
            int count=0;
            for (int num: citations) {
                if (num >= idx) break;
                count++;
            }
            if (n-count >= idx) {
                answer = idx;
                break;
            }
        }
        return answer;
    }
}
