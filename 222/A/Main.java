import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    // 4桁に0埋めして出力
    String res = String.format("%04d", n);

    System.out.println(res);

    // Scannerを閉じる
    sc.close();
  }
}
