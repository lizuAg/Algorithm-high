import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
  private static int solution (int n, int w, int L, List<Integer> weights) {
    Queue<Truck> queue = new LinkedList<>();
    int time = 0;
    int idx = 0;
    int weight = 0;
    while (true) {
      time++;
      if (! queue.isEmpty() && time == queue.peek().exitTime) {
        Truck truck = queue.poll();
        weight -= truck.weight;
      }
      if (weight+weights.get(idx) <= L && queue.size() < w) {
        queue.add(new Truck(weights.get(idx), time+w));
        weight += weights.get(idx);
        idx++;
      }
      if (idx == n)
        break;
    }
    time += w;
    return time;
  }
  static class Truck {
    private int weight;
    private int exitTime;
    
    Truck (int weight, int time) {
      this.weight = weight;
      this.exitTime = time;
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> arg = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    List<Integer> weights = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    System.out.println(solution(arg.get(0), arg.get(1), arg.get(2), weights));
    bf.close();
  }
  
}
