//[프로그래머스] 네트워크 (https://school.programmers.co.kr/learn/courses/30/lessons/43162)

class Solution {
    int[] visited;
    int answer;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];

        for(int i=0; i<n; i++)
            if(visited[i] == 0){
                traverseSubnet(computers, visited, i);
                answer++;
            }

        return answer;
    }
    
    public void traverseSubnet(int[][] computers, int[] visited, int now){
        visited[now] = 1;
        
        for(int i=0; i<computers.length; i++){
            if(visited[i]==0 && computers[now][i] == 1)
                traverseSubnet(computers, visited, i);
        }
    }
}
