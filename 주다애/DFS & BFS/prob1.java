class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        recursion(0, 0, target, numbers);
        return answer;
    }
    
    static void recursion(int level, int sum, int target, int[] numbers) {
        if (level == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        recursion(level + 1, sum + numbers[level], target, numbers);
        recursion(level + 1, sum - numbers[level], target, numbers);
    }
}
