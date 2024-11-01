import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    String n = sc.nextLine();
    String x = n.substring(n.length() - 2);

    if (x.equals("er")) {
      System.out.println("er");
    } else {
      System.out.println("ist");
    }

    // Scannerを閉じる
    sc.close();
  }
}
