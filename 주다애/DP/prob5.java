class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        if(len == 3) {
            return 0;
        }
        int[][] res = new int[2][len + 1];
        // 첯 번째 집 털음
        res[0][0] = money[0];
        // 첫 번째 집 안 털음
        res[1][0] = 0;
        res[1][1] = money[1];
        res[0][1] = money[0];
        
        for(int i = 2; i < len; i++) {
            res[0][i] = Math.max(money[i] + res[0][i - 2], res[0][i - 1]);
            res[1][i] = Math.max(money[i] + res[1][i - 2], res[1][i - 1]);
        }
        // 첫 번째 집과 마지막 집은 인접하므로 같이 못 털음
        return Math.max(res[0][len - 2], res[1][len - 1]);
    }
}
