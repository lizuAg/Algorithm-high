//[프로그래머스] 같은 숫자는 싫어 (https://school.programmers.co.kr/learn/courses/30/lessons/12906)

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new LinkedList<>();
        
        deque.addLast(arr[0]);
        for(int i=1; i<arr.length; i++){
        if(deque.peekLast() != arr[i])
            deque.addLast(arr[i]);
        }

        int[] answer = new int[deque.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = deque.removeFirst();
        }

        return answer;
    }
}
