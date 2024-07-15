import java.util.*;

프로그래머스 lv2 - H-Index (이전 풀이 참고)

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        for (int i=n-1; i>=0; i--) {
            if (citations[i] < n-i) {
                return n-i-1;
            }
        }
        return n;
    }
}
