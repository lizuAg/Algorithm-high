//[프로그래머스] 카펫(https://school.programmers.co.kr/learn/courses/30/lessons/42842)

class Solution {
    public int[] solution(int brown, int yellow) {       
        int[] answer = new int[2];
        
        int length, width;
        int sum = brown + yellow;
        
        for(length=1; length<sum; length++){
            width = sum/length;
            if(yellow == (width-2)*(length-2)){
                answer[0] = width;
                answer[1] = length;
                break;
            }
        }

        return answer;
    }
}
