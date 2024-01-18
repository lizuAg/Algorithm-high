//[프로그래머스] 아이템 줍기(https://school.programmers.co.kr/learn/courses/30/lessons/87694)

class Solution {
    boolean[][] map, visited;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new boolean[102][102];
        visited = new boolean[102][102];
        int result1=0, result2=0;
        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        
        draw(rectangle);                
        

        result1 = dfs(characterX, characterY, itemX, itemY, result1);
        
        visited[characterY][characterX] = false;
        result2 = dfs(itemX, itemY, characterX, characterY, result2);
        
        return result1 < result2 ? result1 : result2;
    }
    
    public void draw (int[][] rectangles) {
        // 테두리
        for(int[] rec : rectangles){
            int x1 = rec[0]*2, y1 = rec[1]*2;
            int x2 = rec[2]*2, y2 = rec[3]*2;

            for(int i=x1; i<x2; i++)
                map[y2][i] = true;
            for(int i=y2; i>y1; i--)
                map[i][x2] = true;
            for(int i=x2; i>x1; i--)
                map[y1][i] = true;
            for(int i=y1; i<y2; i++)
                map[i][x1] = true;
            
            for(int i=x1+1; i<x2; i++)
                for(int j=y1+1; j<y2; j++)
                    map[j][i] = false;
        }
        //내부
        for(int[] rec : rectangles){
            int x1 = rec[0]*2, y1 = rec[1]*2;
            int x2 = rec[2]*2, y2 = rec[3]*2;

            for(int i=x1+1; i<x2; i++)
                for(int j=y1+1; j<y2; j++)
                    map[j][i] = false;
        }
    }
    
    public int dfs(int x, int y, int endX, int endY, int depth){
        
        if(x == endX && y == endY)
            return depth/2;
        else
            visited[y][x] = true; 
        
        if(x <101 && map[y][x+1] && !visited[y][x+1])
            return dfs(x+1, y, endX, endY, depth+1);
        else if(x >= 1 && map[y][x-1] && !visited[y][x-1])
            return dfs(x-1, y, endX, endY, depth+1);
        else if(y < 100 && map[y+1][x] && !visited[y+1][x])
            return dfs(x, y+1, endX, endY, depth+1);
        else if(y >= 1 && map[y-1][x] && !visited[y-1][x])
            return dfs(x, y-1, endX, endY, depth+1);
        
        return Integer.MAX_VALUE;
    }
}
