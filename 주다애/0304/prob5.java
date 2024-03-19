// 프로그래머스 - 기둥과 보
import java.util.*;

class Solution {
    static List<Frame> arr = new ArrayList<>();
    public int[][] solution(int n, int[][] build_frame) {
        int len = build_frame.length;

        for(int i = 0; i < len; i++) {
            Frame f = new Frame(build_frame[i]);
            // 설치
            if(build_frame[i][3] == 1) {
                // 기둥
                if(build_frame[i][2] == 0) {
                    if(isPillar(build_frame[i])) {
                        arr.add(f);
                    }
                }
                // 보
                else {
                    if(isBeam(build_frame[i])) {
                        arr.add(f);                        
                    }
                }
            }
            // 삭제
            else {
                // 임시 삭제
                arr.remove(f);
                boolean canDelete = true;
                for(Frame remain : arr) {
                    int[] pos = {remain.x, remain.y, remain.cons};
                    // 기둥이라면
                    if(remain.cons == 0 && !isPillar(pos)) {
                        canDelete = false;
                        break;
                    }
                    // 보라면
                    if(remain.cons == 1 && !isBeam(pos)) {
                        canDelete = false;
                        break;
                    }
                }
                if(!canDelete) {
                    arr.add(f); // 삭제가 불가능하다면 다시 추가
                }
            }
        }
        // 정렬
        Collections.sort(arr);
        
        int size = arr.size();
        int[][] answer = new int[size][3];
        for(int i = 0; i < size; i++) {
            answer[i][0] = arr.get(i).x;
            answer[i][1] = arr.get(i).y;
            answer[i][2] = arr.get(i).cons;
        }
        
        return answer;
    }
    
    private static boolean isPillar(int[] b) {
        // 바닥 위에 있거나, 다른 기둥 위에 있거나, 보의 한 쪽 끝 부분 위에 있는 경우
        if(b[1] == 0 || arr.contains(new Frame(b[0], b[1]-1, 0)) 
           || arr.contains(new Frame(b[0], b[1], 1)) || arr.contains(new Frame(b[0]-1, b[1], 1))) {
            return true;
        }
        return false;
    }

    private static boolean isBeam(int[] b) {
        // 한쪽 끝 부분이 기둥 위에 있거나, 양쪽 끝 부분이 다른 보와 동시에 연결되어 있는 경우
        if(arr.contains(new Frame(b[0], b[1]-1, 0)) || arr.contains(new Frame(b[0]+1, b[1]-1, 0))
           || (arr.contains(new Frame(b[0]-1, b[1], 1)) && arr.contains(new Frame(b[0]+1, b[1], 1)))) {
            return true;
        }
        return false;
    }
    
    static class Frame implements Comparable<Frame> {
        int x;
        int y;
        int cons;

        Frame(int[] b) {
            this.x = b[0];
            this.y = b[1];
            this.cons = b[2];
        }

        Frame(int x, int y, int cons) {
            this.x = x;
            this.y = y;
            this.cons = cons;
        }

        @Override
        public int compareTo(Frame f) {
            if(this.x != f.x) {
                return this.x - f.x;
            }
            if(this.y != f.y) {
                return this.y - f.y;
            }
            return this.cons - f.cons;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Frame frame = (Frame) obj;
            return x == frame.x && y == frame.y && cons == frame.cons;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, cons);
        }
    }
}
