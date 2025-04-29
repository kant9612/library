import java.util.*;

public class Main {
  static int[] parent;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    // parent配列を作成し、一旦自分自身を親に
    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    // 削除する辺をカウント
    int reduceEdge = 0;

    for (int i = 0; i < M; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      // unionメソッドを使用
      // 既に同じグループ → 閉路を作る → 森にするには削除が必要なのでカウント
      if (!union(u, v)) {
        reduceEdge++;
      }
    }
    System.out.println(reduceEdge);
  }

  // 再起的に親をめぐり、根（代表）を見つける（経路圧縮あり）
  static int find(int x) {
    if (parent[x] == x) {
      return x; // 自分が親ならそのまま返す
    }
    return parent[x] = find(parent[x]); // 経路圧縮（親を直接根にする）
  }

  // 2つの集合を統合
  static boolean union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    // すでに同じ集合にある場合は閉路になるため統合しない
    if (rootX == rootY) {
      return false;
    } else {
      parent[rootX] = rootY;
      return true;
    }
  }
}
