//[프로그래머스] 순위 (https://school.programmers.co.kr/learn/courses/30/lessons/49191)

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] table = new int[n+1][n+1];
        
        for(int i=0; i<results.length; i++){
            int win = results[i][0];
            int lose = results[i][1];
            
            table[win][lose] = 1;
            table[lose][win] = -1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(table[i][k] == 1 && table[k][j] == 1){
                        table[i][j] = 1;
                        table[j][i] = -1;
                    }
                    if(table[i][k] == -1 && table[k][j] == -1){
                        table[i][j] = -1;
                        table[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int cnt = 0; 
            for(int j = 1; j <= n; j++){
                if(table[i][j] != 0) cnt++;
            }
            if(cnt == n-1) answer++;
        }
        
        return answer;
    }
}
