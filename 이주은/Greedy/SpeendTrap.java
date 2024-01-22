//[프로그래머스] 단속카메라

import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        int prevEnd = routes[0][1];
        for(int[] route : routes){
            if(prevEnd < route[0]){
                answer++;
                prevEnd = route[1];
            }
        }
        
        return answer;
    }
}
