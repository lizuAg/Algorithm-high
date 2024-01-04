import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<List<Integer>> marking = new ArrayList<>(Arrays.asList(
                List.of(1, 2, 3, 4, 5),
                List.of(2, 1, 2, 3, 2, 4, 2, 5),
                List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        ));
        List<Integer> scores = new ArrayList<>(Arrays.asList(0, 0, 0));
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (answers[i] == marking.get(j).get(i % marking.get(j).size()))
                    scores.set(j, scores.get(j) + 1);
            }
        }
        int maxScore = scores.stream().mapToInt(Integer::intValue).max().orElse(-1);
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores.get(i) == maxScore) {
                answer.add(i);
            }
        }
        Collections.sort(answer);
        return answer.stream().map(a -> a + 1).mapToInt(Integer::intValue).toArray();
    }
}
