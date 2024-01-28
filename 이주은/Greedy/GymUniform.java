//[프로그래머스] 체육복 (https://school.programmers.co.kr/learn/courses/30/lessons/42862)

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int lostCnt = lost.length;
        boolean[] reserveArray = new boolean[n+1];
        
        Arrays.sort(lost);
        
        for(int r : reserve)
            reserveArray[r] = true;

        for(int i=0; i<lost.length; i++){
            if(reserveArray[lost[i]]){
                reserveArray[lost[i]] = false;
                lostCnt--;
                lost[i] = -1;
            }
        }
        
        for(int l : lost){
            if(l > 1 && reserveArray[l-1]){
                reserveArray[l-1] = false;
                lostCnt--;
            }
            else if(l < n && reserveArray[l+1]){
                reserveArray[l+1] = false;
                lostCnt--;
            }
        }
        
        return n - lostCnt;
    }
}
