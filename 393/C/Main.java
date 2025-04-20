import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    sc.nextInt(); // 入力の N を読み飛ばし（実際には使わない）
    int M = sc.nextInt(); // 辺の数

    int ans = 0;
    Map<String, Integer> cnt = new HashMap<>();

    for (int i = 0; i < M; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();

      if (u == v) {
        // 自己ループは即カウント
        ans++;
      } else {
        // (u,v) を常に u<v になるように整形
        if (u > v) {
          int t = u;
          u = v;
          v = t;
        }
        String key = u + "," + v;
        cnt.put(key, cnt.getOrDefault(key, 0) + 1);
      }
    }

    // 同じ辺が k 回出現していたら、余分な k-1 を足す
    for (int k : cnt.values()) {
      ans += k - 1;
    }

    System.out.println(ans);
  }
}
