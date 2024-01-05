//[프로그래머스] 단어 변환 (https://school.programmers.co.kr/learn/courses/30/lessons/43163)

class Solution {
    boolean[] visited;
    int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        //target이 없으면 return 0;
        int i=0;
        for(; i<words.length; i++)
            if(words[i].equals(target))
                break;
        if(i == words.length)
            return 0;
        
        dfs(begin, target, words, 0);
        
        return answer;
    }

    public void dfs(String begin, String target, String[] words, int count) {
        if(begin.equals(target)) {
            answer = count;
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(visited[i]) continue;

            int cnt = 0;
            for(int j=0; j<begin.length(); j++)
                if(begin.charAt(j) == words[i].charAt(j))
                    cnt++;

            if(cnt == begin.length()-1) {
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }
}
