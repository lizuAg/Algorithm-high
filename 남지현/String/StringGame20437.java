import java.util.*;
import java.io.*;

// 백준 20437 골드5 - 문자열 게임2

public class Main {
  
  static final int MAX_LEN = 10001;
  static final int ALPHABET = 26;

  // 내가 생각해낸 풀이. 철자별 인덱스를 컬렉션에 모두 저장해서 공간복잡도 큼.
  static void mySol() throws Exception {
    
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bf.readLine());
    StringBuilder sb = new StringBuilder();
    
    for (int t=0; t<T; t++) {
      int min=MAX_LEN, max=0;
      List<Integer>[] counts = new List[ALPHABET];
      String W = bf.readLine();
      int K = Integer.parseInt(bf.readLine());
      for (int i=0; i<ALPHABET; i++) {
        counts[i] = new ArrayList<Integer>(MAX_LEN);
      }
      for (int i=0; i<W.length(); i++) {
        counts[(int)(W.charAt(i)-'a')].add(i);
      }
      for (int i=0; i<ALPHABET; i++) {
        List<Integer> indexes = counts[i];
        if (indexes.size() >= K) {
          for (int left=0; left<=indexes.size()-K; left++) {
            min = Math.min(min, indexes.get(left+K-1)-indexes.get(left)+1);
            max = Math.max(max, indexes.get(left+K-1)-indexes.get(left)+1);
          }
        }
      }
      if (min==MAX_LEN && max==0) sb.append(-1).append("\n");
      else sb.append(min).append(" ").append(max). append("\n");
    }
    System.out.print(sb);
  }

  // 찾아본 풀이. character count와 동시에 인덱스를 계산해서 최대 최솟값을 업데이트하는 방법.
  static void sol2() throws Exception {
        
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bf.readLine());
    StringBuilder sb = new StringBuilder();
    for (int t=0; t<T; t++) {
      int min=MAX_LEN, max=-1;
      int[][] counts = new int[ALPHABET][2];
      String W = bf.readLine();
      int K = Integer.parseInt(bf.readLine());
      for (int i=0; i<W.length(); i++) {
        char letter = W.charAt(i);
        int idx = (int) letter - 'a';
        if (counts[idx][0]==0) {
          counts[idx][1]=i;
        }
        counts[idx][0]++;
        if (counts[idx][0]==K) {
          min = Math.min(min, i-counts[idx][1]+1);
          max = Math.max(max, i-counts[idx][1]+1);

          for (int j=counts[idx][1]+1; j<W.length(); j++) {
            if(W.charAt(j)==letter){
              counts[idx][1]=j;
              counts[idx][0]--;
              break;
            }
          }
        }
      }
      if (min==MAX_LEN && max==-1) sb.append(-1).append("\n");
      else sb.append(min).append(" ").append(max). append("\n");
    }
    System.out.print(sb);
  }

  public static void main(String[] args)  throws Exception {
    mySol();
    sol2();
  }
}
