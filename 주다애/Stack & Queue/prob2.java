import java.util.*;

class Solution {
    // 리턴 값을 바꿨는데.. 괜찮을까..?
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int size = progresses.length;
        for(int i = 0; i < size; i++) {
            // Math.ceil을 사용할 때 정수끼리의 계산이 올림이 되게 하려면 double로 바꿔야 한다.
            queue.add((int) Math.ceil((double) (100 - progresses[i]) / (double) speeds[i]));
        }
        
        int first = queue.poll();
        int count = 0;
        while(!queue.isEmpty()) {
            if(first < queue.peek()) {
                answer.add(++count);
                first = queue.poll();
                count = 0;
            }
            else {
                count++;
                queue.poll();
            }
        }
        // 마지막 count 저장해주기
        answer.add(++count);
        return answer;
    }
}
