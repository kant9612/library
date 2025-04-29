import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    if (n >= 42) {
      n = n + 1;
    }

    // 3桁に0埋め
    String res = String.format("%03d", n);

    System.out.println("AGC" + res);

    // Scannerを閉じる
    sc.close();
  }
}
