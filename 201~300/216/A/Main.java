import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    String N = sc.nextLine();
    // "."で分割して配列に格納
    String[] parts = N.split("\\.");

    String x = parts[0];
    String y = parts[1];
    int X = Integer.parseInt(x);
    int Y = Integer.parseInt(y);

    if (Y <= 2) {
      System.out.println(X + "-");
    } else if (Y >= 7) {
      System.out.println(X + "+");
    } else {
      System.out.println(X);
    }

    // Scannerを閉じる
    sc.close();
  }
}
