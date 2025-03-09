
// 区間DP
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[] r = new int[N]; // 行列の行数
    int[] c = new int[N]; // 行列の列数

    for (int i = 0; i < N; i++) {
      r[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    // DPテーブル
    int[][] dp = new int[N][N];

    // 長さlの区間をdpで計算
    for (int l = 1; l < N; l++) { // lは区間の長さ
      for (int i = 0; i < N - l; i++) { // iは区間の開始位置
        int j = i + l; // jは区間の終了位置
        dp[i][j] = Integer.MAX_VALUE;

        // kを分割位置として最小コストを求める
        for (int k = i; k < j; k++) {
          int cost = dp[i][k] + dp[k + 1][j] + r[i] * c[k] * c[j];
          dp[i][j] = Math.min(dp[i][j], cost);
        }
      }
    }

    // dp[0][N-1]に最小計算回数が格納される
    System.out.println(dp[0][N - 1]);
  }
}