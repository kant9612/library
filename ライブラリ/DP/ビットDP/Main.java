// 巡回セールスマン問題
package ライブラリ.DP.ビットDP;

import java.util.*;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int V, E;
  static int[][] dist;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 頂点数|V|, 辺の数|E|
    V = sc.nextInt();
    E = sc.nextInt();
    dist = new int[V][V];

    // 初期化（INFで埋める）
    for (int i = 0; i < V; i++) {
      Arrays.fill(dist[i], INF);
      dist[i][i] = 0; // 自分自身への距離は0
    }

    // 辺の情報を受け取る
    for (int i = 0; i < E; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      int d = sc.nextInt();
      dist[u][v] = d; // 有向グラフ
    }
    sc.close();

    // DPテーブル
    int[][] dp = new int[1 << V][V];
    for (int[] row : dp) {
      Arrays.fill(row, INF);
    }

    // 初期状態（スタートは0）
    dp[1][0] = 0;

    // ビットDP
    for (int S = 1; S < (1 << V); S++) { // 訪問済みの頂点の集合
      for (int u = 0; u < V; u++) { // 最後に訪れた頂点
        if ((S & (1 << u)) == 0)
          continue; // uが訪問済みでない場合スキップ

        for (int v = 0; v < V; v++) { // 次に訪れる頂点
          if ((S & (1 << v)) != 0)
            continue; // vがすでに訪問済みの場合スキップ
          if (dist[u][v] == INF)
            continue; // u → vの道がない場合スキップ

          int newS = S | (1 << v);
          dp[newS][v] = Math.min(dp[newS][v], dp[S][u] + dist[u][v]);
        }
      }
    }
    // 最小距離を求める
    int minCost = INF;
    for (int v = 1; v < V; v++) {
      if (dist[v][0] != INF) { // v → 0に戻れる場合
        minCost = Math.min(minCost, dp[(1 << V) - 1][v] + dist[v][0]);
      }
    }

    // 結果を出力
    System.out.println(minCost == INF ? -1 : minCost);
  }
}
