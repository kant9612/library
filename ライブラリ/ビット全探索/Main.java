package ライブラリ.ビット全探索;
import java.util.*;

public class Main {
  static int N, M;
  static List<Integer>[] S = new ArrayList[10];
  static int[] P = new int[10];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();

    for (int i = 0; i < M; i++) {
      S[i] = new ArrayList<>();
      int k = sc.nextInt();
      for (int j = 0; j < k; j++) {
        int s = sc.nextInt() - 1; // 0-based indexにする
        S[i].add(s);
      }
    }

    for (int i = 0; i < M; i++) {
      P[i] = sc.nextInt();
    }

    sc.close();

    // bit全探索
    int ans = 0; // 条件を満たす電球の合計カウント
    for (int msk = 0; msk < (1 << N); msk++) {
      int ok = 0; // 条件を満たす電球の一時的カウント,これが全てである場合ans++
      for (int m = 0; m < M; m++) {
        int cnt = 0; // ONになっているスイッチのカウント
        for (int s : S[m]) {
          if ((msk & (1 << s)) != 0) {
            cnt++;
          }
        }
        if (cnt % 2 == P[m]) {
          ok++;
        }
      }
      if (ok == M) {
        ans++;
      }
    }
    System.out.println(ans);
  }
}
