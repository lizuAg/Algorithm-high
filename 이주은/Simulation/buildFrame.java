
import java.util.*;

class Solution {
    boolean[][] pillars;
    boolean[][] beams;
    
    public int[][] solution(int n, int[][] build_frame) {
        pillars = new boolean[n+1][n+1];
        beams = new boolean[n+1][n+1];
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] frame : build_frame) {
            int a = frame[2];
            int b = frame[3];
            
            if(a == 0 && b == 1)
                buildPillar(frame[0], frame[1], n);
            else if(a == 1 && b == 1)
                buildBeam(frame[0], frame[1], n);
            else if(a == 0 && b == 0)
                demolishPillar(frame[0], frame[1], n);
            else
                demolishBeam(frame[0], frame[1], n);
        }
        
        for(int x=0; x<n+1; x++) {
            for(int y=0; y<n+1; y++) {
                if(pillars[x][y]) {
                    int[] frame = {x, y, 0};
                    list.add(frame);
                }
                if(beams[x][y]) {
                    int[] frame = {x, y, 1};
                    list.add(frame);
                }
            }
        }
        int[][] answer = new int[list.size()][3];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    void buildPillar(int x, int y, int n) {
        //바닥 위에 있거나
        if(y==0);
        //다른 기둥 위에 있거나
        else if(y>0 && pillars[x][y-1]);
        //보의 왼쪽 위에 있거나
        else if(beams[x][y]);
        //보의 오른쪽 위에 있거나
        else if(x>0 && beams[x-1][y]);
        else
            return;
        
        pillars[x][y] = true;
    }
    
    void buildBeam(int x, int y, int n) {
        if(y == 0)
            return;
        
        //왼쪽 끝부분이 기둥 위에 있거나
        if(y>0 && pillars[x][y-1]);
        //오른쪽 끝부분이 기둥 위에 있거나
        else if(y>0 && x+1<=n && pillars[x+1][y-1]);
        //양쪽 끝부분이 동시에 다른 보와 연결
        else if(x>0 && x<n && beams[x-1][y] && beams[x+1][y]);
        else
            return;
        
        beams[x][y] = true;
    }
    
    void demolishPillar(int x, int y, int n) {
    }
    
    void demolishBeam(int x, int y, int n) {  
    }
}
