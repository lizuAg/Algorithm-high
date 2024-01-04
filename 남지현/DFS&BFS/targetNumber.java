class Solution {
    
    int count = 0;
    int number;
    
    public int solution(int[] numbers, int target) {
        number = target;
        dfs( numbers, 0, 0);
        return count;
    }
    
    private void dfs(int[] numbers, int index, int status) {
        if (index == numbers.length) {
            if (status == number)
                count++;
            return;
        }
        dfs(numbers, index + 1, status - numbers[index]);
        dfs(numbers, index + 1, status + numbers[index]);
    }
}
