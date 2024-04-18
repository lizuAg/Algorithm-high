import java.util.*;

// https://school.programmers.co.kr/questions/35224
// 베껴옴
class Solution {
    static List<Integer> num = new ArrayList<>();
    static List<String> op = new ArrayList<>();
    public int solution(String arr[]) {
        int n = arr.length/2 + 1;
        // 숫자와 연산자 각각 저장
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 0) {
                num.add(Integer.parseInt(arr[i]));
            }
            else {
                op.add(arr[i]);
            }
        }
        // i번째부터~j번째까지 연산의 최소값과 최대값 저장
        int[][] min = new int[n][n];
        int[][] max = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
            Arrays.fill(max[i], Integer.MIN_VALUE);
        }
        for(int step = 0; step < n; step++) {
            for(int i = 0; i < n - step; i++) {
                int j = i + step;
                
                // 자기자신 연산의 최대, 최소 == 나
                if(step == 0) {
                    min[i][i] = num.get(i);
                    max[i][i] = num.get(i);
                }
                else {
                    for(int k = i; k < j; k++) {
                        if(op.get(k).equals("+")) {
                            min[i][j] = Math.min(min[i][j], min[i][k] + min[k+1][j]);
                            max[i][j] = Math.max(max[i][j], max[i][k] + max[k+1][j]);
                            
                        }
                        else {
                            min[i][j] = Math.min(min[i][j], min[i][k] - max[k+1][j]);
                            max[i][j] = Math.max(max[i][j], max[i][k] - min[k+1][j]);
                        }
                    }
                }
            }
        }
        return max[0][n-1];
    }
}
