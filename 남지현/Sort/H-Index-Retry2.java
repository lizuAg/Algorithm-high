import java.util.*;

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
