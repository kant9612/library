import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int ans = 0;

    for (int i = 0; i <= 1000; i++) {
      if (c * i >= a && c * i <= b) {
        ans = c * i;
        break;
      }
    }

    if (ans == 0) {
      System.out.println(-1);
    } else {
      System.out.println(ans);
    }

    // Scannerを閉じる
    sc.close();
  }
}
