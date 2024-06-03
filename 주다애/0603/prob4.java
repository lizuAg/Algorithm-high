import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 2(골드 2)
// 이진탐색
public class BaekJoon12015 {
    static int n;
    static int[] arr;
    static List<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 초기화
        list.add(0);

        for(int num : arr) {
            if (num > list.get(list.size()-1)) {
                // 현재 마지막 원소보다 크면 추가
                list.add(num);
            }
            // 이진 탐색
            else {
                int l = 0;
                int r = list.size() - 1;

                while(l < r) {
                    int mid = (l + r) / 2;
                    // 리스트 중간 원소보다 크면 left 변경
                    if(list.get(mid) < num) l = mid + 1;
                    // 아니면 right 변경
                    else r = mid;
                }
                list.set(r, num);
            }
        }
        System.out.println(list.size() - 1);
    }
}
