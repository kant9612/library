import java.util.*;

public class Main {
  // フェニックツリー（1-indexed）
  static class BIT {
    private final int n;
    private final int[] bit;

    BIT(int n) {
      this.n = n;
      bit = new int[n + 1];
    }

    void add(int i, int v) {
      for (; i <= n; i += i & -i)
        bit[i] += v;
    }

    int sum(int i) {
      int s = 0;
      for (; i > 0; i -= i & -i)
        s += bit[i];
      return s;
    }
  }

  // クエリ (y 閾値, +1 or -1)
  static class Query {
    final int y, sign;

    Query(int y, int sign) {
      this.y = y;
      this.sign = sign;
    }
  }

  // ソート済み配列 A から「A[i] < key を満たす要素の個数」を返す（二分探索）
  static int lowerBound(int[] A, int key) {
    int lo = 0, hi = A.length;
    while (lo < hi) {
      int mid = (lo + hi) >>> 1;
      if (A[mid] < key)
        lo = mid + 1;
      else
        hi = mid;
    }
    return lo;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 円周上の点の総数
    int M = sc.nextInt(); // 直線（弦）の本数

    // (A_i, B_i) の読み込み
    int[][] chord = new int[M][2];
    for (int i = 0; i < M; i++) {
      chord[i][0] = sc.nextInt();
      chord[i][1] = sc.nextInt();
    }
    // Scanner はもう不要
    sc.close();

    // A_i をキーにソート
    Arrays.sort(chord, Comparator.comparingInt(a -> a[0]));

    // ソート後の A,B を別配列に展開
    int[] A_sorted = new int[M], B_sorted = new int[M];
    for (int i = 0; i < M; i++) {
      A_sorted[i] = chord[i][0];
      B_sorted[i] = chord[i][1];
    }

    // 各 x (0…M-1) に対応するオフラインクエリを蓄える
    List<List<Query>> qlist = new ArrayList<>(M);
    for (int i = 0; i < M; i++) {
      qlist.add(new ArrayList<>());
    }

    // 各 p について r_p を二分探索で求め、+1/−1 クエリを登録
    for (int p = 0; p < M; p++) {
      // B_sorted[p] を超えない A_sorted の個数を探す
      int rPlus1 = lowerBound(A_sorted, B_sorted[p]);
      int r = rPlus1 - 1;
      if (r >= p + 1) {
        // 区間 [p+1, r] の範囲を矩形クエリとして扱う
        qlist.get(r).add(new Query(B_sorted[p], +1));
        qlist.get(p).add(new Query(B_sorted[p], -1));
      }
    }

    // BIT＋スイープで矩形クエリを処理
    BIT bit = new BIT(N);
    long ans = 0;
    int added = 0; // これまでに登録した弦の数

    for (int x = 0; x < M; x++) {
      // 点 (x, B_sorted[x]) を登録
      bit.add(B_sorted[x], 1);
      added++;

      // この x に紐づく全クエリを処理
      for (Query q : qlist.get(x)) {
        // y > q.y の個数 = added - bit.sum(q.y)
        int cnt = added - bit.sum(q.y);
        ans += (long) q.sign * cnt;
      }
    }

    System.out.println(ans);
  }
}
