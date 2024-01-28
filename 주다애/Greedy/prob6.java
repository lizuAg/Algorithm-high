import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        List<Car> list = new ArrayList<>();
        for(int[] route : routes) {
            list.add(new Car(route[0], route[1]));
        }
      // end시점으로 오름차순 정렬하는 것이 포인트++
        Collections.sort(list);
        int end = list.get(0).getEnd();
        
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i).getStart() <= end) continue;
            end = list.get(i).getEnd();
            answer++;
        }
        
        return answer+1;
    }
}

class Car implements Comparable<Car> {
    int start;
    int end;
    
    Car(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public int getStart() {
        return this.start;
    }
    
    public int getEnd() {
        return this.end;
    }
    
    public int compareTo(Car c) {
        if(this.end != c.end) {
            return this.end - c.end;
        }
        return this.start - c.start;
    }
}
