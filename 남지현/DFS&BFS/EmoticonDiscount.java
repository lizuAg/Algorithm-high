import java.util.*;
class Solution {
    
    static final Integer[] discount = {90, 80, 70, 60};
    PriorityQueue<int[]> answer = new PriorityQueue<>();
    int[][] user;
    int[] emoticon;
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new PriorityQueue<>((arr1, arr2) -> arr1[0]==arr2[0]? arr2[1]-arr1[1]: arr2[0]-arr1[0]);
        user = users;
        emoticon = emoticons;
        List<Integer> bf = new ArrayList<>();
        dfs(0, emoticon.length, bf);
        return answer.poll();
    }
    
    private void dfs(int depth, int end, List<Integer> cur) {
        if (depth == end) {
            int[] prices = new int[end];
            for (int i=0; i<end; i++) {
                prices[i] = emoticon[i]/100*cur.get(i);
            }
            int total = 0;
            int serviceCount = 0;
            for (int[] u: user) {
                int money=0;
                for (int i=0; i<end; i++) {
                    if (100-u[0] >= cur.get(i)) {
                        money += prices[i];
                        if (money >= u[1]) {
                            money=0;
                            serviceCount++;
                            break;
                        }
                    }
                }
                total += money;
            }
            answer.add(new int[]{serviceCount, total});
            return;
        }
        for (int i=0; i<4; i++) {
            cur.add(discount[i]);
            dfs(depth+1, end, cur);
            cur.remove(cur.lastIndexOf(discount[i]));
        }
    }
}
