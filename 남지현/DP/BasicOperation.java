import java.util.*;
class Solution {
    List<Integer> operands = new ArrayList<>();
    List<String> operators = new ArrayList<>();
    
    public int solution(String arr[]) {
        int N = arr.length/2+1;
        for (String input: arr) {
            try {
                operands.add(Integer.parseInt(input));
            } catch(NumberFormatException e) {
                operators.add(input);
            }
        }
        int[][] min = new int[N][N];
        int[][] max = new int[N][N];
        for (int i=0; i<N; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
            Arrays.fill(max[i], Integer.MIN_VALUE);
        }
        for (int i=0; i<N; i++) {
            min[i][i] = operands.get(i);
            max[i][i] = operands.get(i);
        }
        for (int len=1; len<N; len++) {
            for (int i=0; i<N-len; i++) {
                int j = i+len;
                for (int k=i; k<j; k++) {
                    if (operators.get(k).equals("+")) {
                        min[i][j] = Math.min(min[i][j], min[i][k]+min[k+1][j]);
                        max[i][j] = Math.max(max[i][j], max[i][k]+max[k+1][j]);
                    } else if (operators.get(k).equals("-")) {
                        min[i][j] = Math.min(min[i][j], min[i][k]-max[k+1][j]);
                        max[i][j] = Math.max(max[i][j], max[i][k]-min[k+1][j]);
                    }
                }
            }
        }
        return max[0][N-1];
    }
}
