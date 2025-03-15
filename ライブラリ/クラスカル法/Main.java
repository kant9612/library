package ライブラリ.クラスカル法;

import java.util.*;

public class Main {
  // クラスカル法で使用するEdgeクラス（辺の情報を保持）
  static class Edge implements Comparable<Edge> {
    int u, v, weight;

    Edge(int u, int v, int weight) {
      this.u = u;
      this.v = v;
      this.weight = weight;
    }

    // 辺の重みを基準に照準ソートするための比較関数
    @Override
    public int compareTo(Edge other) {
      return Integer.compare(this.weight, other.weight);
    }
  }

  // Union-Find（Disjoint Set）を実装するクラス
  static class UnionFind {
    int[] parent, rank;

    UnionFind(int n) { // nはノード数
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i; // 各ノードが自分自身を親としている（単一集合）
        rank[i] = 0; // ランクを0に初期化
      }
    }

    // 再起的に親をめぐり、根（代表）を見つける（経路圧縮あり）
    int find(int x) {
      if (parent[x] == x)
        return x; // 自分が親ならそのまま返す
      return parent[x] = find(parent[x]); // 経路圧縮（親を直接根にする）
    }

    // 2つの集合を統合（ランクが低い方を高い方に統合する）
    boolean unite(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX == rootY) // すでに同じ集合にある場合は統合しない
        return false;

      // ランクに基づいて統合（ランクが高い方を親にする）
      if (rank[rootX] > rank[rootY]) {
        parent[rootY] = rootX;
      } else if (rank[rootX] < rank[rootY]) {
        parent[rootX] = rootY;
      } else {
        parent[rootY] = rootX;
        rank[rootX]++; // ランクを更新
      }
      return true;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int V = sc.nextInt(); // 頂点数
    int E = sc.nextInt(); // 辺数

    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < E; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt(); // 頂点数
      int w = sc.nextInt(); // 頂点数
      edges.add(new Edge(u, v, w));
    }
    sc.close();

    // クラスカル法でMSTを求める
    System.out.println(kruskal(V, edges));
  }

  // クラスカル法の実装
  static int kruskal(int V, List<Edge> edges) {
    Collections.sort(edges); // 重み順にソート
    UnionFind uf = new UnionFind(V); //
    int totalWeight = 0;
    int count = 0;

    for (Edge edge : edges) {
      if (uf.unite(edge.u, edge.v)) { // サイクルにならない場合、採用
        totalWeight += edge.weight;
        count++;
        if (count == V - 1)
          break; // V-1本選んだら終了
      }
    }
    return totalWeight;
  }
}