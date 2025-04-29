import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力の読み込み
    int N = sc.nextInt();
    int K = sc.nextInt();
    String S = sc.next();

    int countPairs = 0; // K個の連続する'0'のペア数を記録
    int currentCount = 0; // 現在の連続する'0'の数

    // スライディングウィンドウ法を使って連続する'0'を探す
    for (int i = 0; i < N; i++) {
      if (S.charAt(i) == 'O') {
        currentCount++; // '0'ならカウントを増やす
      } else {
        currentCount = 0; // 'X'が出たらリセット
      }

      // K個の連続する'0'が見つかったらペア数を増やす
      if (currentCount == K) {
        countPairs++;
        // 次の連続ペアを見つけるために、スライドさせる
        currentCount = 0;
      }
    }

    System.out.println(countPairs);

    sc.close();
  }
}
