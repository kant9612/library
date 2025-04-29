import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] d = new int[3];
    d[0] = n / 100; // 百の位
    d[1] = (n / 10) % 10; // 十の位
    d[2] = n % 10; // 一の位

    int m = 100 * d[1] + 10 * d[2] + d[0];
    int l = 100 * d[2] + 10 * d[0] + d[1];

    int ans = n + m + l;

    System.out.println(ans);

    // Scannerを閉じる
    sc.close();
  }
}
