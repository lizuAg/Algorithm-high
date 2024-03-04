class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] school = new int[n+1][m+1];

        // 웅덩이 표시
        for(int[] puddle : puddles) {
            school[puddle[1]][puddle[0]] = -1;
        }
        
        school[1][1] = 1; // 시작점
        // DP로 경로 계산
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i==1 && j==1) continue; // 시작점은 무시
                if(school[i][j] == -1) {
                    school[i][j] = 0;
                    continue;
                }
                school[i][j] = (school[i-1][j] + school[i][j-1]) % 1000000007;
            }
        }
        return school[n][m];
    }
}
