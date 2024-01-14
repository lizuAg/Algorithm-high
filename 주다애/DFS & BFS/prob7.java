import java.util.List;
import java.util.Queue;
import java.util.*;

// 퍼즐 조각 채우기
// 너무 어려웠습니다. 티스토리 코드를 거의 그대로 가져와서 다시 풀어볼 예정입니다.
class Solution {
    List<List<Coor>> tableList = new ArrayList<>();
    List<List<Coor>> boardList = new ArrayList<>();
    boolean[][] visitedTable;
    boolean[][] visitedBoard;
    int answer = 0;

    public int solution(int[][] game_board, int[][] table) {
        int len = game_board.length;
        visitedTable = new boolean[len][len];
        visitedBoard = new boolean[len][len];

        //game_board 0, 1 바꿔주기 --> bfs 함수 하나만 사용하기 위해서
        // 0 : 채워짐, 1 : 비어있음
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(game_board[i][j]==1){
                    game_board[i][j] = 0;
                }
                else game_board[i][j] = 1;
            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                // 보드가 비어있으면
                if(game_board[i][j] == 1 && !visitedBoard[i][j]) {
                    bfs(i, j, visitedBoard, game_board, boardList);
                }
                // 퍼즐 조각이면
                if(table[i][j] == 1 && !visitedTable[i][j]) {
                    bfs(i, j, visitedTable, table, tableList);
                }
            }
        }

        //table의 블록과 board 빈 공간의 블록을 회전하면서 비교해주기
        answer = compare();

        return answer;
    }


    public void bfs(int x, int y, boolean[][] visited, int[][] board, List<List<Coor>> list){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<Coor> q = new LinkedList<>();
        q.offer(new Coor(x, y));
        visited[x][y] = true;

        List<Coor> temp = new ArrayList<>();
        temp.add(new Coor(0, 0));

        while(!q.isEmpty()) {
            Coor coor = q.poll();
            int cx = coor.getX();
            int cy = coor.getY();
            for(int i = 0 ; i < 4; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(enableMove(nx, ny, board.length)) {
                    if(board[nx][ny] == 1 && !visited[nx][ny]) {
                        q.offer(new Coor(nx, ny));
                        visited[nx][ny] = true;
                        // 상대 좌표
                        temp.add(new Coor(nx - x, ny - y));
                    }
                }
            }
        }
        list.add(temp);
    }

    private boolean enableMove(int x, int y, int len) {
        if(x < 0 || x >= len || y < 0 || y >= len) return false;
        return true;
    }

    public int compare(){
        int tableSize = tableList.size();
        int boardSize = boardList.size();

        boolean[] visited = new boolean[boardSize];

        for(int i = 0; i < tableSize; i++){
            for(int j = 0; j < boardSize; j++){
                // 보드가 빈공간이 아니거나 비어있을 때 보드와 퍼즐 사이즈가 다르면
                if(visited[j] || tableList.get(i).size() != boardList.get(j).size())
                    continue;
                // 회전 확인
                if(isRotate(tableList.get(i), boardList.get(j))){
                    visited[j] = true;
                    // 퍼즐 크기 더해주기
                    answer += boardList.get(j).size();
                    break; // 더 이상 비교 필요 없음(끼워넣을 필요 없음)
                }

            }
        }
        return answer;
    }

    public boolean isRotate(List<Coor> table, List<Coor> board){
        // 오름차순 정렬
        Collections.sort(board);
        int tableSize = table.size();
        int boardSize = board.size();

        // 0, 90, 180, 270도 회전
        for(int i = 0; i < 4; i++){
            // 오름차순 정렬. table은 회전할때마다 다시 정렬해줌.
            // 오름차순으로 좌표를 정렬하면 회전해도 일관되게 좌표 비교 가능
            Collections.sort(table);
            boolean flag = true;
            int cx = table.get(0).getX();
            int cy = table.get(0).getY();

            // 상대좌표로 다시 세팅
            for(int j = 0; j < tableSize; j++) {
                table.get(j).x -= cx;
                table.get(j).y -= cy;
            }

            for(int k = 0; k < boardSize; k++) {
                if((board.get(k).getX() != table.get(k).getX()) || (board.get(k).getY() != table.get(k).getY())) {
                    flag = false;
                    break;
                }
            }

            // 보드의 빈 공간과 퍼즐이 딱 맞으면 true 리턴
            if(flag) {
                return true;
            }
            // 아니면 회전해보기
            else {
                for(int k = 0; k < tableSize; k++) {
                    int c = table.get(k).x;
                    table.get(k).x = table.get(k).y;
                    table.get(k).y = -c;
                }
            }
        }
        return false;
    }
}

class Coor implements Comparable<Coor>{
    int x;
    int y;

    Coor(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // 오름차순
    public int compareTo(Coor c){
        if(this.x != c.x) {
            return this.x - c.x;
        }
        else {
            return this.y - c.y;
        }
    }
}
