//[프로그래머스] 다리를 지나는 트럭(https://school.programmers.co.kr/learn/courses/30/lessons/42583)

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int curWeight = 0;
        int time = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int truck : truck_weights){
            while(true){
                //다리가 빈 경우
                if(queue.isEmpty()) {
                    time++;
                    curWeight += truck;
                    queue.add(truck);
                    break;
                }
                //다리 길이 여유가 있음
                else if(queue.size() < bridge_length){
                    //다리 길이 O + 하중 O
                    if(truck + curWeight <= weight){
                        time++;
                        curWeight += truck;
                        queue.add(truck);
                        break;
                    }
                    //다리 길이 여유 O + 하중 X
                    else{
                        time++;
                        queue.add(0);
                    }
                }
                //다리 길이 여유가 없을 경우
                else {
                    curWeight -= queue.poll();
                }
            }
        }
        return time + bridge_length; 
    }
}
