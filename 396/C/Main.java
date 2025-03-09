import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力の取得
    int N = sc.nextInt(); // 黒のボールの数
    int M = sc.nextInt(); // 白のボールの数

    Integer[] black = new Integer[N];
    Integer[] white = new Integer[M];

    for (int i = 0; i < N; i++) {
      black[i] = sc.nextInt();
    }
    for (int i = 0; i < M; i++) {
      white[i] = sc.nextInt();
    }
    sc.close();

    // 降順ソート
    Arrays.sort(black, Collections.reverseOrder());
    Arrays.sort(white, Collections.reverseOrder());

    // 黒ボールの累積和
    long[] S = new long[N + 1];
    for (int i = 1; i <= N; i++) {
      S[i] = S[i - 1] + black[i - 1];
    }

    // 白ボールの累積和と累積最大値
    long[] T = new long[M + 1];
    long[] maxT = new long[M + 1];
    for (int j = 1; j <= M; j++) {
      T[j] = T[j - 1] + white[j - 1];
      maxT[j] = Math.max(maxT[j - 1], T[j]);
    }

    // 最大値を求める
    long maxVal = 0;
    for (int i = 0; i <= N; i++) {
      maxVal = Math.max(maxVal, S[i] + maxT[Math.min(i, M)]);
    }

    // 結果を出力
    System.out.println(maxVal);
  }
}
