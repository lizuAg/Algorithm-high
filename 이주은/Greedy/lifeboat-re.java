//프로그래머스 구명보트 (https://school.programmers.co.kr/learn/courses/30/lessons/42885)

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int high = people.length - 1;
        int low = 0;
        
        Arrays.sort(people);
        
        while(low <= high) {
            if(people[low] + people[high] <= limit) {
                high --;
                low ++;
                answer++;
            }
            else {
                high --;
                answer++;
            }
        }
        return answer;
    }
}
