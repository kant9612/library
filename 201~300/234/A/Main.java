import java.util.*;

public class Main {
  // 関数を定義
  public static int f(int x) {
    return x * x + 2 * x + 3;
  }

  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int ans = 0;

    ans = f(f(f(t) + t) + f(f(t)));
    System.out.println(ans);

    // Scannerを閉じる
    sc.close();
  }
}
