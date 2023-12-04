import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for (int truck_weight : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(truck_weight);
                    sum+=truck_weight;
                    answer++;
                    break;
                } else if (queue.size() < bridge_length) {
                    if (sum + truck_weight <= weight) {
                        queue.add(truck_weight);
                        answer++;
                        sum += truck_weight;
                        break;
                    } else {
                        queue.add(0);
                        answer++;
                    }
                } else {
                    sum -= queue.poll();
                }
            }
        }
        return answer+bridge_length;
    }
}
