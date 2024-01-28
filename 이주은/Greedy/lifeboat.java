//[프로그래머스] 구명보트(https://school.programmers.co.kr/learn/courses/30/lessons/42885?language=java)

import java.util.*;

class Solution {
    static final int EXCEED = 250;
    
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }

        return answer;
    }
}
