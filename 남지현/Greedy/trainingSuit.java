class Solution {
    int[] status;
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        status = new int[n+1];
        for (int i=1; i<n+1; i++) {
            status[i] = 1;
        }
        for (int num: lost) {
            status[num] -= 1;
        }
        for (int num: reserve) {
            status[num] += 1;
        }
        for (int i=1; i<n+1; i++) {
            if (status[i] == 0) {
                if (inRange(n, i-1) && status[i-1] > 1) {
                    status[i-1] -= 1;
                    status[i] += 1;
                } else if (inRange(n, i+1) && status[i+1] > 1) {
                    status[i+1] -= 1;
                    status[i] += 1 ;
                }
            }
        }
        for (int i=1; i<n+1; i++) {
            if (status[i] > 0)
                answer+=1;
        }
        return answer;
    }
    private boolean inRange(int n, int idx) {
        return 0 < idx && idx <= n;
    }
}
