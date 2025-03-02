import java.util.*;

public class Main {
  static int N, currentTime;
  static List<Integer>[] graph;
  static int[] discoveryTime, finishTime;
  static boolean[] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    // グラフの初期化（[]の中で頂点番号を1としている）
    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    // 発見時刻 & 完了時刻の配列
    discoveryTime = new int[N + 1];
    finishTime = new int[N + 1];
    visited = new boolean[N + 1];

    // 入力の読み取り
    for (int i = 0; i < N; i++) {
      int u = sc.nextInt(); // 頂点番号
      int k = sc.nextInt(); // いくつの頂点と結びついているか
      for (int j = 0; j < k; j++) {
        int v = sc.nextInt();
        graph[u].add(v); // 隣接ノードを読み込んでグラフに追加
      }
    }
    sc.close();

    // DFS
    currentTime = 1;
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        dfs(i);
      }
    }

    // 出力
    for (int i = 1; i <= N; i++) {
      System.out.println(i + " " + discoveryTime[i] + " " + finishTime[i]);
    }
  }

  static void dfs(int node) {
    // そのnodeは訪問したためvisited=trueにする
    visited[node] = true;
    discoveryTime[node] = currentTime++;

    for (int neighbor : graph[node]) {
      if (!visited[neighbor]) {
        dfs(neighbor);
      }
    }

    finishTime[node] = currentTime++;
  }
}
