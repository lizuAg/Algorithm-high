//프로그래머스 이모티콘 할인 행사 (https://school.programmers.co.kr/learn/courses/30/lessons/150368)

import java.util.*;

class Solution {
    int[][] USERS;
    int[] EMOTICONS;
    int eLen;
    
    int[] visited;
    int[] RATES = {90, 80, 70, 60};
    PriorityQueue<int[]> pq;
    
    public int[] solution(int[][] users, int[] emoticons) {
        USERS = users;
        EMOTICONS = emoticons;
        eLen = emoticons.length;
        
        pq = new PriorityQueue<>(
            (arr1, arr2) -> arr1[0] != arr2[0] ? arr2[0] - arr1[0] : arr2[1] - arr1[1]
        );
        
        visited = new int[emoticons.length];
        
        dfs(0);
        
        return pq.poll();
    }
    
    void dfs(int curr) {
        if(curr == eLen) {
            calcuate();
            return;
        }
        
        for(int rate: RATES) {
            visited[curr] = rate;
            dfs(curr+1);
        }
    }
    
    void calcuate() {
        int[] result = new int[2];
        int[] discounts = new int[eLen];
        
        for(int i=0; i<eLen; i++) {
            discounts[i] = EMOTICONS[i] * visited[i] /100;
        }
        
        for(int[] user: USERS) {
            int sum = 0;
            for(int i=0; i<eLen; i++) {
                if(user[0] <= 100 - visited[i]) {
                    sum += discounts[i];
                }
            }
            
            if(sum >= user[1])
                result[0] += 1;
            else
                result[1] += sum;
        }
        pq.add(result);
    }
}
