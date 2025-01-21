import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力の読み込み
    int N = sc.nextInt(); // 空港AからBへの便数
    int M = sc.nextInt(); // 空港BからAへの便数
    int X = sc.nextInt(); // AからBへの飛行時間
    int Y = sc.nextInt(); // BからAへの飛行時間

    int[] a = new int[N];
    int[] b = new int[M];

    for (int i = 0; i < N; i++) {
      a[i] = sc.nextInt(); // 空港AからBへの便の出発時刻
    }

    for (int i = 0; i < M; i++) {
      b[i] = sc.nextInt(); // 空港BからAへの便の出発時刻
    }

    int roundTrips = 0;
    int currentTime = 0;

    // バイナリサーチを用いて往復可能回数を計算
    while (true) {
      // 空港AからBへの便を探す
      int nextFlightToB = Arrays.binarySearch(a, currentTime);
      if (nextFlightToB < 0) {
        nextFlightToB = -nextFlightToB - 1;
      }
      if (nextFlightToB == N)
        break; // 見つからない場合終了
      currentTime = a[nextFlightToB] + X;

      // 空港BからAへの便を探す
      int nextFlightToA = Arrays.binarySearch(b, currentTime);
      if (nextFlightToA < 0) {
        nextFlightToA = -nextFlightToA - 1;
      }
      if (nextFlightToA == M)
        break; // 見つからない場合終了
      currentTime = b[nextFlightToA] + Y;

      // 往復カウントを増やす
      roundTrips++;
    }

    // 結果を出力
    System.out.println(roundTrips);

    sc.close();
  }
}
