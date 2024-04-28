import java.util.*;
import java.io.*;

class Main {

    static final int[] dx = {0, -1, 0, 1};
    static final int[] dy = {1, 0, -1, 0};

    private static int index(int idx, int dir) {
        int mod = (idx+dir)%4;
        if (mod<0) mod=3;
        return mod;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int i=0; i<N; i++) {
            int minX=0; int maxX=0; int minY=0; int maxY=0;
            int x=0; int y=0;
            int dir=0;
            char[] ops = bf.readLine().toCharArray();
            for (char op: ops) {
                if (op=='F') {
                    x+=dx[dir];
                    y+=dy[dir];
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                } else if (op=='B') {
                    x-=dx[dir];
                    y-=dy[dir];
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                } else if (op=='L') {
                    dir = index(dir, +1);
                } else if (op=='R') {
                    dir = index(dir, -1);
                }
            }
            System.out.println(Math.abs(maxX-minX)*Math.abs(maxY-minY));
        }
    }
}
