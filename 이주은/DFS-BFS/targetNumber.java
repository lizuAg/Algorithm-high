//[프로그래머스] 타겟 넘버(https://school.programmers.co.kr/learn/courses/30/lessons/43165)

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int sum){
        if(depth == numbers.length){
            if(target == sum) answer ++;
            return;
        }
        
        dfs(numbers, target, depth+1, sum + numbers[depth]);
        dfs(numbers, target, depth+1, sum - numbers[depth]);
    }
}
