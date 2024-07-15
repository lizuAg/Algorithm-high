import java.util.Scanner;

// 고층 건물(골드 4)
// 기울기 비교
public class BaekJoon1027 {
    static int n;
    static int[] building;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        building = new int[n];
        // 입력
        for (int i = 0; i < n; i++) {
            building[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, getInclination(i));
        }
        System.out.println(ans);
    }

    private static int getInclination(int idx) {
        int cnt = 0;
        double tempInclination = 0;

        for (int i = idx - 1; i >= 0; i--) {
            double inclination = (double) (building[idx] - building[i]) / (idx - i);
            if(i == idx - 1 || tempInclination > inclination) {
                tempInclination = inclination;
                cnt++;
            }
        }

        for (int i = idx + 1; i < n; i++) {
            double inclination = (double) (building[idx] - building[i]) / (idx - i);
            if(i == idx + 1 || tempInclination < inclination) {
                tempInclination = inclination;
                cnt++;
            }
        }
        return cnt;
    }
}
