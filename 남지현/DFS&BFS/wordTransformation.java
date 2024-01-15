import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.word.equals(target))
                return node.depth;
            for (String word : words) {
                if (node.depth == words.length)
                    return 0;
                if (node.transformedInto(word)) {
                    queue.add(new Node(word, node.depth + 1));
                }
            }
        }
        return 0;
    }
    
    static class Node {
        private String word;
        private int depth;

        Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }

        boolean transformedInto(String word) {
            int count = 0;
            char[] chars = this.word.toCharArray();
            char[] newChars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != newChars[i]) {
                    count++;
                }
            }
            return count == 1;
        }
    }
}
