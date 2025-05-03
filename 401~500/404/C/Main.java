import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    // サイクルグラフ：辺の数と頂点の数が同じになる？
    if (M != N) {
      System.out.println("No");
      sc.close();
      return;
    }

    // 隣接リスト
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= N; i++) { // 1~N の頂点番号をそのまま使う
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < M; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      adj.get(u).add(v);
      adj.get(v).add(u);
    }
    sc.close();

    // 各頂点から出る辺は2本であるはず
    for (int i = 0; i <= N; i++) {
      if (adj.get(i).size() != 2) {
        System.out.println("No");
        return;
      }
    }

    boolean[] seen = new boolean[N + 1];
    Deque<Integer> dq = new ArrayDeque<>();
    dq.add(1); // 1つ目をdqに入れる
    seen[1] = true; // 1つ目を訪問済み
    int count = 1; // 訪れた頂点の数
    while (!dq.isEmpty()) {
      int u = dq.poll();
      for (int w : adj.get(u)) {
        if (!seen[w]) { // まだ未訪問だったら
          seen[w] = true;
          count++;
          dq.add(w);
        }
      }
    }

    // 訪れた頂点の数がNと同じならOK
    System.out.println(count == N ? "Yes" : "No");
  }
}
