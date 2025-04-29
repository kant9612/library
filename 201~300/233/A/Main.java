import java.util.*;

public class Main {

  // 切り上げロジック
  public static int ceil(int a, int b) {
    return (a + b - 1) / b;
  }

  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();
    int ans = 0;

    if (x >= y) {
      ans = 0;
    } else {
      ans = ceil(y - x, 10);
    }

    System.out.println(ans);

    // Scannerを閉じる
    sc.close();
  }
}
