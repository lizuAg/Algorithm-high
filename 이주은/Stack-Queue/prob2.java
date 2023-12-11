//[프로그래머스] 기능개발 (https://school.programmers.co.kr/learn/courses/30/lessons/42586)

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] compDays = new int[progresses.length];
        
        //완료 일수 계산
        for(int i=0; i<progresses.length; i++){
            double daysDouble =  (100 - progresses[i])/(double)speeds[i];
            compDays[i] = (int) Math.ceil(daysDouble);
            System.out.println(compDays[i]);
        }
        
        for(int i=0; i<progresses.length; i++){
            int cnt = 1;
            for(int j=i+1; j<progresses.length; j++){
                if(compDays[i] >= compDays[j])
                    cnt++;
                else
                    break;
            }
            i += cnt -1;
            list.add(cnt);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
