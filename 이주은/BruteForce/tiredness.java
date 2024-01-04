//[프로그래머스] 피로도(https://school.programmers.co.kr/learn/courses/30/lessons/87946#)

class Solution {
    public int answer;
    public boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }

    public void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false; //경로에서 돌아옴. 다른 경로에서 방문 가능하게 false.
            }
        }
        if(answer < depth)
            answer = depth;
    }
}
