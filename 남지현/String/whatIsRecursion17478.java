import java.io.*;

public class Main {
	
  static StringBuilder builder;
  final static String UNDER_BAR = "____";
  
  private static void recursion(int depth, int N) {
    builder.append(UNDER_BAR.repeat(depth));
    builder.append("\"재귀함수가 뭔가요?\"\n");
    
    if (depth==N) {
      builder.append(UNDER_BAR.repeat(depth));
      builder.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
      builder.append(UNDER_BAR.repeat(depth));
      builder.append("라고 답변하였지.\n");
      return;
    }
    
    builder.append(UNDER_BAR.repeat(depth));
    builder.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
    builder.append(UNDER_BAR.repeat(depth));
    builder.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
    builder.append(UNDER_BAR.repeat(depth));
    builder.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
    
    recursion(depth+1, N);
    
    builder.append(UNDER_BAR.repeat(depth));
    builder.append("라고 답변하였지.\n");
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    builder = new StringBuilder();
    builder.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
    recursion(0, N);
    System.out.println(builder);
  }
}
