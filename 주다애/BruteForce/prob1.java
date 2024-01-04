import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int len = sizes.length;
        int answer = 0;
        // 정렬 후 비교
        for(int i = 0; i < len; i++) {
            Arrays.sort(sizes[i]);
        }
        int hMax = 0;
        int vMax = 0;
        for(int i = 0; i < len; i++) {
            if(sizes[i][0] > hMax) {
                hMax = sizes[i][0];
            }
            if(sizes[i][1] > vMax) {
                vMax = sizes[i][1];
            }
        }
        answer = hMax * vMax;
        return answer;
    }
}
