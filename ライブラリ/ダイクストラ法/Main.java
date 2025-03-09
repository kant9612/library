
// ダイクストラ法
import java.util.*;

public class Main {
  static final long INF = Integer.MAX_VALUE / 2;
  static List<List<Edge>> graph;
  static long[] dist;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int V = sc.nextInt(); // 頂点
    int E = sc.nextInt(); // 辺の数
    int r = sc.nextInt(); // 始点

    // グラフの初期化
    graph = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }

    // 辺の入力
    for (int i = 0; i < E; i++) {
      int u = sc.nextInt(); // 出発ノード
      int v = sc.nextInt(); // 到着ノード
      int d = sc.nextInt(); // 距離
      graph.get(u).add(new Edge(v, d));
    }
    sc.close();

    // ダイクストラ法を実行
    dijkstra(V, r);

    // 結果の出力
    for (int i = 0; i < V; i++) {
      if (dist[i] == INF) {
        System.out.println("INF");
      } else {
        System.out.println(dist[i]);
      }
    }
  }

  static void dijkstra(int V, int start) {
    dist = new long[V];
    Arrays.fill(dist, INF);
    dist[start] = 0;

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.offer(new Edge(start, 0));

    while (!pq.isEmpty()) {
      Edge current = pq.poll();
      int u = current.to;
      long cost = current.cost;

      // 最短距離でない場合はスキップ
      if (dist[u] < cost)
        continue;

      // 隣接ノードの更新
      for (Edge e : graph.get(u)) {
        int v = e.to;
        long newCost = dist[u] + e.cost;

        if (newCost < dist[v]) {
          dist[v] = newCost;
          pq.offer(new Edge(v, newCost));
        }
      }
    }
  }

  // Edgeクラス（優先度付きキュー用）
  static class Edge implements Comparable<Edge> {
    int to;
    long cost;

    Edge(int to, long cost) {
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
      return Long.compare(this.cost, other.cost);
    }
  }
}
