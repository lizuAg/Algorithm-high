import java.util.*;
import java.io.*;

class Main {

    static List<LinkedList<Character>> gear = new ArrayList<>();

    private static void rotate(int num, int dir) {
        if (dir==-1) {
            gear.get(num).addLast(gear.get(num).pollFirst());
        } else {
            gear.get(num).addFirst(gear.get(num).pollLast());
        }
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<4; i++) {
            char[] input = bf.readLine().toCharArray();
            gear.add(new LinkedList<Character>());
            for (char c: input) {
                gear.get(i).addLast(c);
            }
        }
        int K = Integer.parseInt(bf.readLine());
        
        for (int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            List<int[]> tmp = new ArrayList<>(); 
            tmp.add(new int[]{num, dir});
            int newDir = dir;
            int right = num+1;
            while (right<4 && gear.get(right-1).get(2)!=gear.get(right).get(6)) {
                newDir *= -1;
                tmp.add(new int[]{right, newDir});
                right++;
            }
            newDir = dir;
            int left = num-1;
            while (left>=0 && gear.get(left+1).get(6)!=gear.get(left).get(2)) {
                newDir *= -1;
                tmp.add(new int[]{left, newDir});
                left--;
            }
            for (int[] op: tmp) {
                rotate(op[0], op[1]);
            }
        }
        
        int count=0;
        for (int i=0; i<4; i++) {
            int score = gear.get(i).getFirst()-'0';
            count += score * Math.pow(2, i);
        }
        System.out.println(count);
    }
}
