//[프로그래머스] 금과 은 운반하기 (https://school.programmers.co.kr/learn/courses/30/lessons/86053)

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int N = g.length;
        long start = 0, end = 400000000000000L;
        
        while(start < end) {
            long total = 0L, totalGold = 0L, totalSilver = 0L;
            long time = (start + end) / 2;
            for(int i=0; i<N; i++) {
                long trips = time / (2L*t[i]);
                if(time % (2L*t[i]) >= t[i])
                    trips ++;
                
                long sum = Math.min(trips*w[i], g[i] + s[i]);
                
                total += sum;
                totalGold += Math.min(sum, g[i]);
                totalSilver += Math.min(sum, s[i]);
            }
            
            if((total >= a + b) && (totalGold >= a) && totalSilver >= b)
                end = time;
            else
                start = time + 1;
        }
        return end;
    }
}
