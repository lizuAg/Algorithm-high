import java.util.*;
import java.io.*;

class Main {
    static int[][] gears = new int[4][8];
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<4; i++) {
            String[] line = br.readLine().split("");
            for(int j=0; j<8; j++) {
                gears[i][j] = Integer.parseInt(line[j]);
            }
        }
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            
            int gear = Integer.parseInt(line[0])-1;
            int dir = Integer.parseInt(line[1]);

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {gear, dir});

            //왼쪽 <- 확인
            for(int j=gear-1; j>=0; j--) {
                if(gears[j][2] != gears[j+1][6]){
                    int temp = (gear - j) == 2 ? dir : -1*dir; 
                    queue.add(new int[] {j, temp});
                }
                break;
            }

            //오른쪽 -> 확인
            for(int j=gear+1; j<4; j++) {
                if(gears[j][6] != gears[j-1][2]) {
                    int temp = (j - gear) == 2 ? dir : -1*dir;
                    queue.add(new int[] {j, temp});
                }
                break;
            }

            while(!queue.isEmpty()) {
                rotate(queue.poll());
            }
        }
        
        br.close();

        int answer = 0;
        if(gears[0][0]==1)answer+=1;
        if(gears[1][0]==1)answer+=2;
        if(gears[2][0]==1)answer+=4;
        if(gears[3][0]==1)answer+=8;

        System.out.println(answer);
    }

    static void rotate(int[] arr) {
        int gear = arr[0];
        int dir = arr[1];
        int temp, prev;
        
        if(dir == 1) {
            prev = gears[gear][7];
            for(int i=0; i<8; i++) {
                temp = gears[gear][i];
                gears[gear][i] = prev;
                prev = temp;
            }
            return;
        }
        
        prev = gears[gear][0];
        for(int i=7; i>=0; i--) {
            temp = gears[gear][i];
            gears[gear][i] = prev;
            prev = temp;
        }
    }
}
