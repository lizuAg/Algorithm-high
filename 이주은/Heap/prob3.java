//[프로그래머스] 이중우선순위큐(https://school.programmers.co.kr/learn/courses/30/lessons/42628)

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations){
            String[] tokens = operation.split(" ");
            int num;
            if(tokens[0].equals("I")){
                num = Integer.parseInt(tokens[1]);
                minHeap.add(num);
                maxHeap.add(num);
            }
            else if(!minHeap.isEmpty()){
                if(tokens[1].equals("1")){
                    num = maxHeap.poll();
                    minHeap.remove(num);
                }  
                else
                    num = minHeap.poll();
                    maxHeap.remove(num);
            }
        }
        if(!minHeap.isEmpty()){
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        return answer;
    }
}
