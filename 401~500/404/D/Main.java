import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 動物園の数
    int M = sc.nextInt(); // 動物の種類
    long[] C = new long[N]; // 入園料
    for (int i = 0; i < N; i++) {
      C[i] = sc.nextLong();
    }
    // 種類iが見れる動物園のリスト
    List<Integer>[] kindsInZoo = new ArrayList[M];
    for (int i = 0; i < M; i++) {
      kindsInZoo[i] = new ArrayList<>();
      int K = sc.nextInt();
      for (int j = 0; j < K; j++) {
        int zoo = sc.nextInt() - 1;
        kindsInZoo[i].add(zoo);
      }
    }
    sc.close();

    long ans = Long.MAX_VALUE;
    int total = (int) Math.pow(3, N);
    // 3進数で見れば良い？
    for (int mask = 0; mask < total; mask++) {
      int m = mask;
      long cost = 0;
      int[] visits = new int[N];
      // 各動物園の訪問回数を見て、合計コストを計算する
      for (int j = 0; j < N; j++) {
        visits[j] = m % 3;
        m /= 3;
        cost += visits[j] * C[j];
        // コストがansを超えたら次へ
        if (cost > ans) {
          break;
        }
      }
      if (cost > ans) {
        continue;
      }

      // 各動物園について、見れる回数が2回以上が必要
      boolean ok = true;
      for (int i = 0; i < M; i++) {
        int count = 0;
        for (int zoo : kindsInZoo[i]) {
          count += visits[zoo];
          if (count >= 2) {
            break;
          }
        }
        if (count < 2) {
          ok = false;
          break;
        }
      }
      if (ok) {
        ans = cost;
      }
    }
    System.out.println(ans);
  }
}