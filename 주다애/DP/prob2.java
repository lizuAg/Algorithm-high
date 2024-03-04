import java.util.*;

// 완전 탐색
class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] res = new int[len][len];
        res[0][0] = triangle[0][0];
        for(int i = 1; i < len; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    res[i][j] = res[i - 1][0] + triangle[i][j];
                } else if(j == i) {
                    res[i][j] = res[i - 1][j - 1] + triangle[i][j];
                } else {
                    res[i][j] = Math.max(res[i - 1][j - 1], res[i - 1][j]) + triangle[i][j];
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < len; i++) {
            answer = Math.max(answer, res[len - 1][i]);
        }
        return answer;
    }
}
