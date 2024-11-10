import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力の読み込み
    int N = sc.nextInt(); // マスの数
    int M = sc.nextInt(); // 石が置かれているマスの数

    int[] X = new int[M];
    int[] A = new int[M];
    long totalStones = 0;

    for (int i = 0; i < M; i++) {
      X[i] = sc.nextInt();
    }

    for (int i = 0; i < M; i++) {
      A[i] = sc.nextInt();
      totalStones += A[i];
    }

    // 石の合計がNでなければ-1を出力
    if (totalStones != N) {
      System.out.println("-1");
      return;
    }

    int[] stones = new int[N];
    Arrays.fill(stones, 0);

    // 石の初期配置
    for (int i = 0; i < M; i++) {
      stones[X[i] - 1] = A[i]; // マスの位置を0-based indexに調整
    }

    // 移動コストの計算
    int moves = 0;
    for (int i = 0; i < N - 1; i++) {
      int diff = stones[i] - 1;
      stones[i] = 1; // 現在のマスの石の数を1に調整

      // 石が不足している場合は不可能
      if (stones[i] < 1 || diff < 0) {
        System.out.println("-1");
        return;
      }

      // 差分を次のマスに移動
      stones[i + 1] += diff;
      // moves += Math.abs(diff);
      moves++;
    }

    // 最終結果を出力
    System.out.println(moves);
    sc.close();
  }
}
