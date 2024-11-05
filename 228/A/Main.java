import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    int s = sc.nextInt();
    int t = sc.nextInt();
    int x = sc.nextInt();
    String ans = "No";

    if (s < t) {
      if (s <= x && x < t) {
        ans = "Yes";
      }
    } else if (s > t) {
      if ((s <= x && x < 24) || (0 <= x && x < t)) {
        ans = "Yes";
      }
    }
    System.out.println(ans);

    // Scannerを閉じる
    sc.close();
  }
}
