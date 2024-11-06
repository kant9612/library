import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    double n = sc.nextDouble();
    double ans = 0;
    ans = n / 100;

    System.out.println(ans);

    // Scannerを閉じる
    sc.close();
  }
}
