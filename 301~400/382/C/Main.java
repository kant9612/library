import java.util.*;

public class Main {
  private static final int K = 200010;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    // id[x] = おいしさ x の寿司を最初に食べる人の番号（1-based）。未割り当ては-1としておく。
    int[] id = new int[K];
    Arrays.fill(id, -1);

    // r は「まだ誰にも割り当てられていない美味しさ」の上限
    int r = K;
    for (int i = 0; i < N; i++) {
      int a = sc.nextInt();
      while (r > a) {
        r--;
        id[r] = i + 1;
      }
    }

    // 寿司の美味しさごとに出力
    for (int i = 0; i < M; i++) {
      int b = sc.nextInt();
      System.out.println(id[b]);
    }
    sc.close();
  }
}
