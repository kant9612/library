import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    if (n < 100) {
      System.out.println("No");
    } else if (n % 100 != 0) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }

    // Scannerを閉じる
    sc.close();
  }
}
