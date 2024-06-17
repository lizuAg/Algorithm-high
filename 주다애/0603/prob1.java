// 이진 탐색
class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        long left = 0;
        long right = (long)1e15;  // 최대 시간. Long.MAX_VALUE는 너무 커서 안되나..?
        int len = w.length;
        // 이진 탐색
        while(left <= right) {
            long mid = (left + right) / 2;
            long gold = 0, silver = 0, sum = 0;
            for(int i = 0; i < len; i++) {
                long cnt = mid / (t[i] * 2);
                // 편도
                if(mid % (t[i] * 2) >= t[i]) cnt++;
                gold += Math.min(g[i], w[i] * cnt);
                silver += Math.min(s[i], w[i] * cnt);
                sum += Math.min(g[i] + s[i], w[i] * cnt); // 금과 은 동시 운반
            }
            if(gold >= a && silver >= b && sum >= a + b) {
                right = mid - 1;
                answer = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
