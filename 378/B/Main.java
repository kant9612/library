import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int largeNumber = 1_000_000_000; // 10の9乗

    // ゴミの種類数Nを読み込む
    int N = sc.nextInt();

    // 各ゴミの収集間隔と開始日を格納する配列
    int[] q = new int[N];
    int[] r = new int[N];

    // ゴミの収集間隔q_iと開始日r_iを読み込む
    for (int i = 0; i < N; i++) {
      q[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    // 質問数Qを読み込む
    int Q = sc.nextInt();

    // 各質問を処理
    for (int j = 0; j < Q; j++) {
      int t_j = sc.nextInt() - 1; // ゴミの種類（0ベースに調整）
      int d_j = sc.nextInt(); // 出た日

      int interval = q[t_j];
      int startDay = r[t_j];

      // 次に収集される日を計算
      if (d_j <= startDay) {
        System.out.println(startDay);
      } else {
        for (int n = 0; n <= largeNumber + 1; n++) {
          if ((interval * n + startDay) >= d_j) {
            System.out.println(interval * n + startDay);
            break;
          }
        }
      }
    }

    sc.close();
  }
}
