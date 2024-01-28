//[프로그래머스] 큰 수 만들기 (https://school.programmers.co.kr/learn/courses/30/lessons/42883#)

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();
        
        deque.addLast(number.charAt(0));
        for(int i=1; i<number.length(); i++){
            char ch = number.charAt(i);
            while(k > 0 && !deque.isEmpty() && deque.peekLast() < ch){
                deque.removeLast();
                k--;
            }
            deque.addLast(ch);
        }
        
        while(!deque.isEmpty()){
            sb.append(deque.poll());
        }        
        
        return sb.substring(0, sb.length()-k);
    }
}
