import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    if (n >= 90) {
      System.out.println("expert");
    } else if (n >= 70 && n < 90) {
      System.out.println(90 - n);
    } else if (n >= 40 && n < 70) {
      System.out.println(70 - n);
    } else if (n >= 0 && n < 40) {
      System.out.println(40 - n);
    }

    // Scannerを閉じる
    sc.close();
  }
}
