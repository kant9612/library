import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 部門の数
    long[] K = new long[N]; // 部門iに所属する人数
    long S = 0; // 全部門の人数
    for (int i = 0; i < N; i++) {
      K[i] = sc.nextLong();
      S += K[i];
    }
    sc.close();

    // 1 を左にNビットシフトする。2のN乗を計算する。
    // これが全ての部門（N）を選ぶか選ばないか　のパターン数。
    // 例）N=3 の時、2の3乗 = 8 となり、部門を選ぶ/選ばないの組み合わせは8通り。
    int total = 1 << N;
    long ans = S; // 初期値は「全員が同時に食べる」
    long[] dp = new long[total];
    dp[0] = 0;

    // dp[mask] = 部分集合 mask の合計
    for (int mask = 1; mask < total; mask++) {
      int lb = mask & -mask; // 最下位ビットを取り出し
      int i = Integer.numberOfTrailingZeros(lb); // mask のビットのうち、一番下に立っている 1 が何番目の部門か
      dp[mask] = dp[mask ^ lb] + K[i];  // dp[mask ^ lb]は既に計算済みだからそれにK[i]を足し込めばOK
    }

    // 全列挙して、「max(dp[mask], S-dp[mask])の最小値を探す
    for (int mask = 0; mask < total; mask++) {
      long a = dp[mask];
      long b = S - a;
      long m = (a > b ? a : b);
      if (m < ans) {
        ans = m;
      }
    }
    System.out.println(ans);
  }
}
