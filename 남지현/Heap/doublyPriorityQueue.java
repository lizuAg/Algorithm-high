import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) throws IOException {
        List<Integer> answer = new ArrayList<>();
        DoublyPriorityQueue queue = new DoublyPriorityQueue();
        for (String operation : operations) {
            queue.calculate(operation);
        }

        answer.add(queue.getMax());
        answer.add(queue.getMin());
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    class DoublyPriorityQueue {
        PriorityQueue<Integer> ascendQueue;
        PriorityQueue<Integer> descendQueue;

        DoublyPriorityQueue() {
            this.ascendQueue = new PriorityQueue<>();
            this.descendQueue = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void calculate(String instruction) throws IOException {
            String[] instructions = instruction.split(" ");
            int arg = Integer.parseInt(instructions[1]);
            
            if (instructions[0].equals("I")) {
                ascendQueue.add(arg);
                descendQueue.add(arg);
                
            } else if (instructions[0].equals("D") && ascendQueue.size() > 0) {
                if (arg == 1) {
                    Integer poll = descendQueue.poll();
                    ascendQueue.remove(poll);
                } else if (arg == -1) {
                    Integer poll = ascendQueue.poll();
                    descendQueue.remove(poll);
                }
            }

        }

        public int getMax() {
            if (descendQueue.size() > 0)
                return descendQueue.peek();
            return 0;
        }
        
        public int getMin() {
            if (ascendQueue.size() > 0)
                return ascendQueue.peek();
            return 0;
        }
    }
}
