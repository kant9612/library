import java.util.*;

public class Main {
  // クラスフィールドとして宣言
  static int n;
  static int k;
  static int[] a;

  // dfsメソッド
  public static boolean dfs(int i, int sum) {
    if (i == n) {
      return sum == k;
    }

    // a[i]を使わない場合
    if (dfs(i + 1, sum)) {
      return true;
    }

    // a[i]を使う場合
    if (dfs(i + 1, sum + a[i])) {
      return true;
    }

    return false;
  }

  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    // n, k の入力
    n = sc.nextInt();
    a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    k = sc.nextInt();

    // dfsの実行結果で判定
    if (dfs(0, 0)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    // Scannerを閉じる
    sc.close();
  }
}
