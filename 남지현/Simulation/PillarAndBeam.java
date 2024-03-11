import java.util.*;
class Solution {
    Set<Frame> result;
    public int[][] solution(int n, int[][] build_frame) {
        result = new HashSet<>();
        for (int[] frame: build_frame) {
            Frame target = new Frame(frame[0], frame[1], frame[2]);
            if (frame[3] == 0) {
                target.remove();
            } else {
                target.add();
            }
        }
        List<Frame> collect = new ArrayList<>();
        for (Frame fr: result) {
            collect.add(fr);
        }
        Collections.sort(collect);
        int[][] answer = new int[collect.size()][3];
        for (int i=0; i<collect.size(); i++) {
            answer[i] = collect.get(i).convertArr();
        }
        return answer;
    }
    
    class Frame implements Comparable<Frame> {
        private int x;
        private int y;
        private int type;
        
        Frame(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
        
        @Override
        public boolean equals(Object o) {
            Frame obj = (Frame) o;
            return this.x==obj.x && this.y==obj.y && this.type==obj.type;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y, type);
        }
        
        @Override
        public int compareTo(Frame obj) {
            if (this.x==obj.x) {
                if (this.y==obj.y) {
                    return this.type-obj.type;
                } else {
                    return this.y-obj.y;
                }
            } else {
                return this.x-obj.x;
            }
        }
        
        public boolean add() {
            boolean success = false;
            if (this.type == 0) {
                success = ( y==0 
                    || result.contains(new Frame(this.x, this.y, 1)) 
                    || result.contains(new Frame(this.x-1, this.y, 1))
                    || result.contains(new Frame(this.x, this.y-1, 0))
                );
            } else {
                success = ( y!=0
                    && (result.contains(new Frame(this.x, this.y-1, 0))
                    || result.contains(new Frame(this.x+1, this.y-1, 0))
                    || (result.contains(new Frame(this.x-1, this.y, 1))
                        && result.contains(new Frame(this.x+1, this.y, 1))))
                );
            }
            if (success) {
                result.add(this);
            }
            return success;
        }
        
        public boolean remove() {
            boolean success = true;
            result.remove(this);
            for (Frame fr: result) {
                if (! fr.add()) {
                    success = false;
                }
            }
            if (!success) {
                result.add(this);
            }
            return success;
        }
        
        public int[] convertArr() {
            return new int[]{this.x, this.y, this.type};
        }
    }
}
