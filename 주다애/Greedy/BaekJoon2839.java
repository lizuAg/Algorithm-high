import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 설탕 배달(실버 4)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sugar = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while(sugar > 0) {
            if(sugar % 5 == 0) {
                sugar = sugar - 5;
                cnt++;
            }
            else if(sugar % 3 == 0) {
                sugar = sugar - 3;
                cnt++;
            }
            else {
                sugar -= 5;
                cnt++;
            }
        }
        if(sugar != 0) System.out.println(-1);
        else System.out.println(cnt);
    }
}
