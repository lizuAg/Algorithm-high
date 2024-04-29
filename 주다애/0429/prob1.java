import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 거북이(실버 3)
public class Main {
    // 상 우 하 좌
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <n; i++) {
            String turtle = sc.next();
            res.add(move(turtle));
        }
        for(int r : res) {
            System.out.println(r);
        }
    }

    private static int move(String op) {
        int len = op.length();
        int cx = 0;
        int cy = 0;
        int cd = 0;
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        xList.add(cx);
        yList.add(cy);
        for(int i = 0; i < len; i++) {
            char c = op.charAt(i);
            if(c == 'F') {
                cx += dir[cd][0];
                cy += dir[cd][1];
                xList.add(cx);
                yList.add(cy);
                continue;
            }
            if(c == 'B') {
                cx -= dir[cd][0];
                cy -= dir[cd][1];
                xList.add(cx);
                yList.add(cy);
                continue;
            }
            if(c == 'L') {
                cd = (cd + 3) % 4;
                continue;
            }
            if(c == 'R') {
                cd = (cd + 1) % 4;
                continue;
            }
        }
        int xLen = xList.size();
        int yLen = yList.size();
        Collections.sort(xList);
        Collections.sort(yList);
        int x = xList.get(xLen - 1) - xList.get(0);
        int y = yList.get(yLen - 1) - yList.get(0);
        return x * y;
    }
}
