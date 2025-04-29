import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    String n = sc.nextLine();
    // "."で分割して配列に格納
    String[] parts = n.split("");

    String x = parts[0];
    String y = parts[1];
    String z = parts[2];

    if (x.equals(y) && y.equals(z)) {
      System.out.println("1");
    } else if (x.equals(y) || y.equals(z) || x.equals(z)) {
      System.out.println("3");
    } else {
      System.out.println("6");
    }

    // Scannerを閉じる
    sc.close();
  }
}
