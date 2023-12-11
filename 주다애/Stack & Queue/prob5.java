import java.util.*;

class Truck {
    public static void main(String[] args) {
        Truck truck = new Truck();
        int res = truck.solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(res);
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        for(Integer t : truck_weights) {
            while(true) {
                if(q.isEmpty()) {
                    q.offer(t);
                    sum += t;
                    answer++;
                    break;
                }
                else if(q.size() == bridge_length) {
                    int target = q.poll();
                    sum -= target;
                    answer++;
                    if(sum + t <= weight) {
                        q.offer(t);
                        sum += t;
                        break;
                    }
                    else {
                        // while문 무한루프 방지. 0을 넣어줘서 sum에 영향 안주고 while문 진행시킴
                        q.offer(0);
                    }
                }
                // 어차피 하나씩 offer해주므로 q.size()가 bridge_length를 넘어갈 일이 없다.
                else {
                    answer++;
                    if(sum + t <= weight) {
                        q.offer(t);
                        sum += t;
                        break;
                    }
                    else {
                        q.offer(0);
                    }
                }
            }
        }
        return answer+bridge_length;
    }
}