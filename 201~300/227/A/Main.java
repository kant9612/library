import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int A = sc.nextInt();
    int ans = 0;

    ans = (A + K - 1) % N;
    if (ans == 0)
      ans = N;
    System.out.println(ans);

    // Scannerを閉じる
    sc.close();
  }
}
