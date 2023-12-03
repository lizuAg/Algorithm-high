import java.util.*;

class DoublePQ {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        // 오름차순
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        // 내림차순
        PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());

        int len = operations.length;
        for(String str : operations) {
            String[] op = str.split("\\s");
            // 삽입
            if(op[0].equals("I")) {
                asc.offer(Integer.parseInt(op[1]));
                desc.offer(Integer.parseInt(op[1]));
            }
            // 삭제
            else if(op[0].equals("D")) {
                if(op[1].equals("1")) {
                    if(!desc.isEmpty()) {
                        int t = desc.poll();
                        asc.remove(t);
                    }
                }
                else if(op[1].equals("-1")) {
                    if(!asc.isEmpty()) {
                        int t = asc.poll();
                        desc.remove(t);
                    }
                }
            }
        }
        if(!asc.isEmpty() && !desc.isEmpty()) {
            answer[0] = desc.peek();
            answer[1] = asc.peek();
        }
        else {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}