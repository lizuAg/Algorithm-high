//[프로그래머스] 주식가격 (https://school.programmers.co.kr/learn/courses/30/lessons/42584)

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        
        for(int i=0; i<N; i++){
            int curr = prices[i];
            int days = 0;
            for(int j=i+1; j<N; j++) {
                days++;
                int next = prices[j];
                if(curr > next)
                    break;
            }
            answer[i] = days;
        }

        return answer;
    }
}
