import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int gap = a - b;

    // 累乗計算
    double res = Math.pow(32, gap);
    // キャスト double → int
    int ans = (int) res;

    System.out.println(ans);

    // Scannerを閉じる
    sc.close();
  }
}
