import java.util.*;

// 멀티탭 스케줄링(골드 1)
// 그리디 -> 유형 파악을 못 하고 서치해서 코드 작성
public class BaekJoon1700 {
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> device = new ArrayList<>();
        // list에 저장
        for (int i = 0; i < K; i++) {
            device.add(sc.nextInt());
        }
        // 멀티탭에 꽃힌 기구
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < K; i++) {
            int t = device.get(i);
            // 이미 꽃힘
            if(set.contains(t)) continue;
            // 멀티탭에 자리가 있고 꽃히지 않음
            if(set.size() < N && set.add(t)) continue;
            int target = -1;
            int maxIdx = -1;
            for(int s : set) {
                int idx = device.subList(i + 1, K).indexOf(s);
                // 더이상 사용 안하면 그냥 그거 뽑으면 됨
                if(idx == -1) {
                    target = s;
                    break;
                }
                // 가장 나중에 사용되는 것 뽑음
                if(idx > maxIdx) {
                    maxIdx = idx;
                    target = s;
                }
            }
            set.remove(target);
            set.add(t);
            count++;
        }
        System.out.println(count);
    }
}
