class Solution {
    boolean[] visited;
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        recursion(0, k, dungeons);
        return answer;
    }
    
    public void recursion(int c, int k, int[][] dungeons) {
        int len = dungeons.length;
        for(int i = 0; i < len; i++) {
            if(visited[i] || dungeons[i][0] > k) {
                continue;
            }
            visited[i] = true;
            recursion(c + 1, k - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        answer = Math.max(c, answer);
    }
}
