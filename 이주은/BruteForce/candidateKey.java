//[프로그래머스] 후보키 (https://school.programmers.co.kr/learn/courses/30/lessons/42890#)

import java.util.*;

class Solution {
    int col, row, answer = 0;
    boolean[] visited;
    String[][] table;
    Set<String> keySet = new HashSet<>();
    
    public int solution(String[][] relation) {
        table = relation;
        col = relation[0].length;
        row = relation.length;
        
        visited = new boolean[col];
        
        for(int i=1; i<=col; i++)
            backtracking(0, 0, i);
        
        return answer;
    }
    
    private void backtracking(int start, int depth, int max) {
        if(depth == max) {
            checkKey();
            return;
        }
        
        for(int i=start; i<col; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backtracking(i+1, depth+1, max);
                visited[i] = false;
            }
        }
    }
    
    private void checkKey() {
        if(!checkUniqueness())
            return;
        
        if(!checkMinimality())
            return;
        
        answer ++;
    }
    
    public boolean checkUniqueness () {
        Set<String> set = new HashSet<>();

        for(int i=0; i<row; i++) {
            StringBuilder sb = new StringBuilder("");
            
            for(int j=0; j<col; j++) {
                if(visited[j]){
                    sb.append(table[i][j]);
                    sb.append("/");
                }
            }
            if(!set.add(sb.toString()))
                return false;
        }
        return true;
    }
    
    private boolean checkMinimality() {        
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<col; i++) {
            if(visited[i])
                sb.append(i);
        }
        String s = sb.toString();
        
        for(String key: keySet) {
            boolean flag = true;
            for(int i=0; i<key.length(); i++){
                if(!s.contains(key.charAt(i)+"")){

