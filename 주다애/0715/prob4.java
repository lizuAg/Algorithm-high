import java.util.*;

class Solution {
    public int solution(int[] citations) {
       int answer = 0;
        Arrays.sort(citations);
        int len = citations.length;
        // 0 1 3 5 6
        for(int i = 0; i < len; i++) {
            int temp = len - i;
            if(citations[i] >= temp) {
                answer = temp;
                break;
            }
        }
        return answer;
    }
}
