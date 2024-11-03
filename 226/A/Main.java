import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    // 少数を含む数を入力
    double n = sc.nextDouble();
    // 整数部分にする
    int m = (int) n;
    // 入力から整数をひいて少数のみにする
    int first = (int) ((n - m) * 10);

    if (first >= 5) {
      System.out.println(m + 1);
    } else {
      System.out.println(m);
    }

    // Scannerを閉じる
    sc.close();
  }
}
