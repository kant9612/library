import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int Q = sc.nextInt();

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < Q; i++) {
      int type = sc.nextInt();
      if (type == 1) {
        // 「1 X」：末尾に X を追加
        int X = sc.nextInt();
        queue.offer(X);
      } else {
        // 「2」：先頭を取り出して出力
        System.out.println(queue.poll());
      }
    }
    sc.close();
  }
}
