import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner scanner = new Scanner(System.in);

    // 1行目: NとMを入力
    int N = scanner.nextInt();
    int M = scanner.nextInt();

    // 2行目: N個の整数を配列Aに格納
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = scanner.nextInt();
    }

    // 3行目: M個の整数を配列Bに格納
    int[] B = new int[M];
    for (int i = 0; i < M; i++) {
      B[i] = scanner.nextInt();
    }

    // 小さい順にソート
    Arrays.sort(A);
    Arrays.sort(B);

    int x = 0;
    int y = 0;

    int INF = Integer.MAX_VALUE;
    int ans = INF;

    while (x < N && y < M) {
      ans = Math.min(ans, Math.abs(A[x] - B[y]));
      if (A[x] > B[y]) {
        y++;
      } else {
        x++;
      }
    }

    System.out.println(ans);

    // Scannerを閉じる
    scanner.close();
  }
}
