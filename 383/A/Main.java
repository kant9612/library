import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力を読み込む
    int N = sc.nextInt();
    int[] T = new int[N];
    int[] V = new int[N];
    for (int i = 0; i < N; i++) {
      T[i] = sc.nextInt();
      V[i] = sc.nextInt();
    }

    // 加湿器内の水量を計算
    int currentTime = 0;
    int waterAmount = 0;

    for (int i = 0; i < N; i++) {
      // 経過時間分、水が減る
      int elapsedTime = T[i] - currentTime;
      waterAmount = Math.max(0, waterAmount - elapsedTime);

      // 水を追加
      waterAmount += V[i];

      // 現在時刻を更新
      currentTime = T[i];
    }

    // 最終的な水量を出力
    System.out.println(waterAmount);

    sc.close();
  }
}
