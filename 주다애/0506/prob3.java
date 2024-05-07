import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 폭발(골드 4)
// stack 사용 문제
// 문자열 StringBuilder로 풂
public class BaekJoon9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String bomb = br.readLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            // 입력 문자열의 각 문자를 result에 추가
            result.append(input.charAt(i));

            // result의 길이가 폭발 문자열의 길이보다 크거나 같고
            // result의 마지막 부분이 폭발 문자열과 같다면
            // == result 길이가 n이면 n-2~n-1인덱스까지의 문자열이 bomb과 같으면
            if (result.length() >= bomb.length() &&
                    result.substring(result.length() - bomb.length()).equals(bomb)) {
                // 폭발 문자열 제거
                // bomb 길이 만큼 제거한다.
                result.delete(result.length() - bomb.length(), result.length());
            }
        }

        // 결과 출력
        System.out.println(result.length() > 0 ? result : "FRULA");
    }
}
