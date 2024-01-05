import java.util.*;

// BFS로 리팩토링
class Solution {
public int solution(String begin, String target, String[] words) {
        int len = words.length;
        boolean[] visited = new boolean[len];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(begin, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.getWord();
            int step = pair.getStep();

            if(word.equals(target)) return pair.getStep();

            for(int i = 0; i < len; i++) {
                if(changeWord(word, words[i]) && !visited[i]) {
                    queue.offer(new Pair(words[i], step + 1));
                    visited[i] = true;
                }
            }
        }

        return 0;
    }

    private boolean changeWord(String cur, String word) {
        int cnt = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}

class Pair {
    String word;
    int step;

    Pair(String word, int step) {
        this.word = word;
        this.step = step;
    }

    public String getWord() {
        return word;
    }

    public int getStep() {
        return step;
    }
}
