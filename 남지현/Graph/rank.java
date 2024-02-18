import java.util.*;
class Solution {
    int[][] dists;    
  
    public int solution(int n, int[][] results) {
        int count = 0;
        dists = new int[n+1][n+1];
        for (int[] result: results) {
            dists[result[0]][result[1]] = 1;
        }
        for (int k=1; k<n+1; k++) {
            for (int i=1; i<n+1; i++) {
                for (int j=1; j<n+1; j++) {
                    if (dists[i][k] == 1 && dists[k][j] == 1) {
                        dists[i][j]=1;
                    }
                }
            }
        }
        for (int i=1; i<n+1; i++) {
            int sum = 0;
            for (int j=1; j<n+1; j++) {
                if (dists[i][j]==1 || dists[j][i]==1) {
                    sum++;
                }
            }
            if (sum == n-1)
                count++;
        }
        return count;
    }
}
