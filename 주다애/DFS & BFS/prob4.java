class Solution {
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, 0, words, visited);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public void dfs(String presentWord, String target, int count, String[] words, boolean[] visited) {
        if (presentWord.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canChange(presentWord, words[i])) {
                visited[i] = true;
                dfs(words[i], target, count + 1, words, visited);
                visited[i] = false;
            }
        }
    }

    public boolean canChange(String presentWord, String nextWord) {
        int count = 0;
        for (int i = 0; i < presentWord.length(); i++) {
            if (presentWord.charAt(i) != nextWord.charAt(i)) {
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}
