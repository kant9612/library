package ライブラリ.ワーシャルフロイド法;

import java.util.*;

public class Main {
  static final int INF = 1_000_000_000; // 大きい値をINFとして設定

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int V = sc.nextInt();
    int E = sc.nextInt();

    // 最短距離を格納する配列
    int[][] dist = new int[V][V];

    // 初期化（INFで埋める）
    for (int i = 0; i < V; i++) {
      Arrays.fill(dist[i], INF);
      dist[i][i] = 0; // 自分への距離は0
    }

    // 辺の入力
    for (int i = 0; i < E; i++) {
      int u = sc.nextInt(); // 出発ノード
      int v = sc.nextInt(); // 到着ノード
      int d = sc.nextInt(); // 距離
      dist[u][v] = d; // 重みを設定
    }
    sc.close();

    // ワーシャルフロイド法を実行
    for (int k = 0; k < V; k++) { // 中間点をkとする
      for (int i = 0; i < V; i++) { // 出発点
        for (int j = 0; j < V; j++) { // 到着点
          if (dist[i][k] != INF && dist[k][j] != INF) { // 経由可能なら更新
            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
          }
        }
      }
    }

    // 負の閉路をチェック
    for (int i = 0; i < V; i++) {
      if (dist[i][i] < 0) { // 負の閉路があれば
        System.out.println("NEGATIVE CYCLE");
        return;
      }
    }

    // 結果の出力
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (dist[i][j] == INF) {
          System.out.println("INF");
        } else {
          System.out.println(dist[i][j]);
        }
        if (j < V - 1) {
          System.out.print(" ");
        }
        System.out.println();
      }
    }
  }
}
