import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  static List<List<int[]>> combinations = new ArrayList<>();
  static List<int[]> houses = new ArrayList<>();
  static List<int[]> stores = new ArrayList<>();
  
  private static int solution(int N, int M, List<List<Integer>> map) {
    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        if (map.get(i).get(j) == 1)
          houses.add(new int[]{i, j});
        else if (map.get(i).get(j) == 2)
          stores.add(new int[]{i, j});
      }
    }
    int answer = Integer.MAX_VALUE;
    for (int i=0; i<stores.size(); i++) {
      combination(stores.size(), i, M, 1, new ArrayList<>());
    }
    for (List<int[]> com: combinations) {
      int cityDist= 0;
      for (int[] house: houses) {
        int houseDist = Integer.MAX_VALUE;
        for (int[] chicken: com) {
          houseDist = Math.min(dist(house, chicken), houseDist);
        }
        cityDist += houseDist;
      }
      answer = Math.min(answer, cityDist);
    }
    return answer;
  }
  
  private static void combination(int n, int idx, int k, int depth, List<int[]> tmpList) {
    tmpList.add(stores.get(idx));
    if (k == depth) {
      combinations.add(tmpList);
      return;
    }
    for (int i=idx+1; i<n; i++) {
      List<int[]> copy = new ArrayList<>();
      copy.addAll(tmpList);
      combination(n, i, k, depth+1, copy);
    }
  }
  
  private static int dist(int[] pt1, int[] pt2) {
    return Math.abs(pt1[0]-pt2[0])+Math.abs(pt1[1]-pt2[1]);
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> arg = Arrays.stream(bf.readLine().split(" ")).map(i -> Integer.parseInt(i)).collect(Collectors.toList());
    List<List<Integer>> map = new ArrayList<>();
    for (int i=0; i<arg.get(0); i++) {
      map.add(Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
    }
    System.out.println(solution(arg.get(0), arg.get(1), map));
    bf.close();
    
  }
  
}
