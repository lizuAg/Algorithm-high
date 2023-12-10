import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        // 오름차순 정렬
        Arrays.sort(citations);
        for(int i = 0; i < len; i++) {
            int cnt = len - i;
            if(citations[i] >= cnt) {
                answer = cnt;
                break;
            }
        }
        return answer;
    }
}
