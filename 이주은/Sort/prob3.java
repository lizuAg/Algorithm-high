//[프로그래머스] H-Index(https://school.programmers.co.kr/learn/courses/30/lessons/42747#)

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i; //h번 이상 인용된 논문 수
            if (citations[i] >= h) { //h번 인용된 논문이면
                answer = h;
                break;
            }
        }
        return answer;
    }
}
