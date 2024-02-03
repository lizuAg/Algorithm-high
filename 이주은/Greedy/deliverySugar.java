//[백준] 설탕배달 #2839

import java.util.Scanner;
import java.io.*;

class Main {
     public static void main(String[] args) throws IOException {
         Scanner scan = new Scanner(System.in);
         int N = scan.nextInt();
         scan.close();
         
         int a=0, b, r;
         
         b = N/5;
         r = N%5;
         
         while(b >= 0) {
             if(r%3 == 0){
                 a = r/3;
                 break;
             }
             b--;
             r += 5;
         }
         if(b != -1)
             System.out.printf("%d", a+b);
         else
             System.out.printf("%d", -1);
     }
}
