//[프로그래머스] 주식가격 (https://school.programmers.co.kr/learn/courses/30/lessons/42584)

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++){
            answer[i] = prices.length - i - 1;
            for(int j=i+1; j<prices.length; j++){
                if(prices[j] < prices[i]){
                    answer[i] = j - i;
                    break;
                }       
            }
        }
        return answer;
    }
}
