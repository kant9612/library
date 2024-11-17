import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    int[] v = { 1, 5, 10, 50, 100, 500 };
    int n = 6;
    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
      c[i] = sc.nextInt();
    }
    int a = sc.nextInt();
    int ans = 0;

    for (int i = 5; i >= 0; i--) {
      int t = Math.min(a / v[i], c[i]); // コインiを使う枚数
      a -= t * v[i];
      ans += t;
    }

    System.out.println(ans);
    // Scannerを閉じる
    sc.close();
  }
}
