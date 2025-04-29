import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    String N = sc.nextLine();
    // "."で分割して配列に格納
    String[] parts = N.split(" ");

    String x = parts[0];
    String y = parts[1];

    // 辞書順で比較
    int res = x.compareTo(y);

    if (res < 0) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    // Scannerを閉じる
    sc.close();
  }
}
