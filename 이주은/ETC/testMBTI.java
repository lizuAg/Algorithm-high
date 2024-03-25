//[프로그래머스] 성격 유형 검사 (https://school.programmers.co.kr/learn/courses/30/lessons/118666)

import java.util.*;

class Solution {
    int N;
    List<Character> typeList = Arrays.asList('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N');
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        N = survey.length;
        
        for(Character type: typeList)
            map.put(type, 0);
        
        for(int i=0; i<N; i++) {
            int choice = choices[i];
            
            int score;
            Character type;
            
            if(choice < 4) {
                type = survey[i].charAt(0);
                score = 4 - choice;
            }
            else if (choice > 4) {
                type = survey[i].charAt(1);
                score = choice - 4;
            }
            else {
                continue;
            }
            
            map.replace(type, map.get(type)+score);
        }
        
        for(int i=0; i<8; i++){
            char a = typeList.get(i);
            char b = typeList.get(++i);
            
            if(map.get(a) >= map.get(b))
                sb.append(a);
            else
                sb.append(b);
        }
        return sb.toString();
    }
}
