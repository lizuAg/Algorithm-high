//[백준] 주식 #11501

import java.io.*;

class Main {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
         int T = Integer.parseInt(br.readLine());
         
         for(int i=0; i<T; i++){
             int sum = 0;
             int days = Integer.parseInt(br.readLine());
             
             String[] input = br.readLine().split(" ");
             
             int[] prices = new int[days];
             for (int j = 0; j<days; j++)
                 prices[j] = Integer.parseInt(input[j]);
             
             int high = prices[days-1];
             for(int j=days-2; j>=0; j--){
                 if(prices[j] > high){
                     high = prices[j];
                 }
                 else{
                     sum += high - prices[j];
                 }
             }
             bw.append(sum + "\n");
         }
         br.close();
         bw.close();
     }
}
