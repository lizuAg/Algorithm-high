import java.util.*;

class Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();

        // truck을 넣어주면서 계산해준다.
        for (Integer truck : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.offer(truck);
                    answer++;
                    sum += truck;
                    break;
                }
                // 다리가 다 차있는 경우
                else if (q.size() == bridge_length) {
                    // 맨 앞의 트럭을 빼준다.
                    int out = q.poll();
                    sum -= out;
                    answer++;
                    // 현재 트럭으로 계산한다.
                    if (sum + truck <= weight) {
                        sum += truck;
                        q.offer(truck);
                        break;
                    }
                    else {
                        // 자릿수 채우기
                        q.offer(0);
                    }
                }
                // 다리가 다 차지 않은 경우
                else {
                    // 일단 개수 +1을 해준다.
                    answer++;
                    if (sum + truck <= weight) {
                        sum += truck;
                        q.offer(truck);
                        break;
                    }
                    else {
                        // 자릿수 채우기
                        q.offer(0);
                    }
                }
            }
        }
        return (answer + bridge_length);
    }
}