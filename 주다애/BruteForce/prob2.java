import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int len = answers.length;
        List<Integer> answer = new ArrayList<>();
        int[] temp = {0, 0, 0};
        for(int i = 0; i < len; i++) {
            if(a[i % 5] == answers[i]) {
                temp[0]++;
            }
            if(b[i % 8] == answers[i]) {
                temp[1]++;
            }
            if(c[i % 10] == answers[i]) {
                temp[2]++;
            }
        }
        int max = -1;
        for(int i = 0; i < temp.length; i++) {
            if(temp[i] >= max) {
                max = temp[i];
            }
        }
        int cnt = 0;
        for(int i = 0; i < temp.length; i++) {
            if(temp[i] == max) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
