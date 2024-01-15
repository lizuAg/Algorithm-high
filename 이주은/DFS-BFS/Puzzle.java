import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    int size;
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        size = game_board.length;
        Deque<int[]> queue = new ArrayDeque<>();
        List<Block> blankList = new ArrayList<>();
        List<Block> blockList = new ArrayList<>();
        
        //빈칸 찾기
        int idx = 2;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                    if(game_board[i][j] == 0) {
                        int[] loc = {i, j};
                        queue.add(loc);
                        loc = mark(game_board, queue, idx, 0);
                        makeBlock(game_board, loc, blankList, idx);
                        idx++;
                    }
            }

        }
        
        //블록 찾기
        idx = 2;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(table[i][j] == 1) {
                    int[] loc = {i, j};
                    queue.add(loc);
                    loc = mark(table, queue, idx, 1);
                    makeBlock(table, loc, blockList, idx); 
                    idx++;
                }   
            }
        }
        
        //빈칸에 맞는 블록 찾기
        for (Block blank : blankList) {
            Iterator<Block> iterator = blockList.iterator();

            while (iterator.hasNext()) {
                Block block = iterator.next();
                if (blank.size != block.size)
                    continue;
                
                boolean flag = false;
                for (int i = 0; i < 4; i++) {
                    flag = blank.shapesMatch(block.shape);
                    if (flag) {
                        answer++;
                        iterator.remove();
                        break;
                    }
                    block.rotate();
                }
                if (flag)
                    break;
            }
        }
        
        return answer;
}
    
    //bfs로 탐색하며 빈칸/블록에 idx로 마킹함.
    public int[] mark(int[][] map, Deque<int[]> queue, int idx, int flag){
        int minY = Integer.MAX_VALUE, minX = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            if(minY > now[0])
                minY = now[0];
            if(minX > now[1])
                minX = now[1];
            
            map[now[0]][now[1]] = idx;
            
            for(int i=0; i<4; i++){
                int x = now[1] + dx[i];
                int y = now[0] + dy[i];
                
                if(x >= 0 && x < size && y >= 0 && y < size && map[y][x]==flag){
                    int[] yx = {y, x};
                    queue.add(yx);
                }
            }
        }
        int[] startLoc = {minY, minX};
        return startLoc;
    }
    
    public void makeBlock(int[][] map, int[] start, List<Block> list, int idx) {
        int[][] shape = new int[3][3];
        int cnt = 0;
        idx = map[start[0]][start[1]];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int y = start[0]+i, x = start[1]+j;
                if(y<size && x<size && map[y][x] == idx){
                    shape[i][j] = 1;
                    cnt++;
                }
            }
        }
        list.add(new Block(shape, cnt));
    }
}

class Block {
    int[][] shape;
    int size;
    
    public Block(int[][] shape, int size){
        this.shape = shape;
        this.size = size;
    }
    
    public void rotate(){
        int[][] temp = this.shape;
        
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                shape[j][2-i] = temp[i][j]; 
    }
    
    public boolean shapesMatch(int[][] other){
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(shape[i][j] != shape[j][i])
                    return false;
        
        return true;
    }
    
    public void print(){
        for(int[] line : shape){
            for(int i : line)
                System.out.print(i+" ");
            System.out.println("");
        }

        System.out.println("");
    }
}
