import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, 
        int j = people.length - 1;
        int answer = 0;

        while(i <= j) {
            // 가장 가벼운 사람과 가장 무거운 사람을 함께 태울 수 있는지 확인
            if(people[i] + people[j] <= limit) {
                i++;
            }
            // 무거운 사람 혼자 태움
            j--;
            answer++;
        }
        return answer;
    }
}
