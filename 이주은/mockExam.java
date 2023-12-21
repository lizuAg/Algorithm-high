//[프로그래머스] 모의고사 (https://school.programmers.co.kr/learn/courses/30/lessons/42840)

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] scoreCnt = {0, 0, 0};
        int[] omr1 = {1, 2, 3, 4, 5};
        int[] omr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] omr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == omr1[i%omr1.length])
                scoreCnt[0]++;
            if(answers[i] == omr2[i%omr2.length])
                scoreCnt[1]++;
            if(answers[i] == omr3[i%omr3.length])
                scoreCnt[2]++;
        }
        int maxScore = scoreCnt[0] > scoreCnt[1] ? scoreCnt[0] : scoreCnt[1];
        if(maxScore < scoreCnt[2])
                maxScore = scoreCnt[2];
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++)
            if(scoreCnt[i] == maxScore)
                list.add(i+1);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);

        
        return answer;
    }
}
