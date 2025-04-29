import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力の受け取り
    int N = sc.nextInt(); // ARC の回数
    int R = sc.nextInt(); // 初期レーティング

    int[] D = new int[N];
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      D[i] = sc.nextInt(); // Division
      A[i] = sc.nextInt(); // 成績
    }

    // レーティング計算開始
    int currentRating = R;

    for (int i = 0; i < N; i++) {
      if (D[i] == 1 && currentRating >= 1600 && currentRating <= 2799) {
        // Div.1 の更新対象
        currentRating += A[i];
      } else if (D[i] == 2 && currentRating >= 1200 && currentRating <= 2399) {
        // Div.2 の更新対象
        currentRating += A[i];
      }
    }

    // 結果の出力
    System.out.println(currentRating);

    sc.close();
  }
}
