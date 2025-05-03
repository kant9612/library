import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Nの読み込み
    long N = sc.nextLong();
    int M = sc.nextInt();
    // 駒の位置をセットに格納（存在判定用）
    HashSet<Long> occupied = new HashSet<>();
    long[] a = new long[M], b = new long[M];
    for (int i = 0; i < M; i++) {
      a[i] = sc.nextLong();
      b[i] = sc.nextLong();
      // key = (row << 32) | col
      occupied.add((a[i] << 32) | b[i]);
    }
    sc.close();

    // 8方向のベクトル
    int[] dx = { +2, +1, -1, -2, -2, -1, +1, +2 };
    int[] dy = { +1, +2, +2, +1, -1, -2, -2, -1 };

    // 攻撃されるマスをセットに格納（重複排除）
    HashSet<Long> attacked = new HashSet<>();
    for (int i = 0; i < M; i++) {
      long x = a[i], y = b[i];
      for (int d = 0; d < 8; d++) {
        long nx = x + dx[d];
        long ny = y + dy[d];
        if (nx < 1 || nx > N || ny < 1 || ny > N) {
          continue;
        }
        long key = (nx << 32) | ny;
        // 空マスかつ未登録の場合、attacked に追加
        if (!occupied.contains(key)) {
          attacked.add(key);
        }
      }
    }
    // 空マスの総数
    long totalEmpty = N * N - M;
    // 置けないマス
    long cantPlace = attacked.size();
    // 置けるマス
    long ans = totalEmpty - cantPlace;
    System.out.println(ans);
  }
}
