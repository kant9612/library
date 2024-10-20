import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine(); // 1行の入力を取得

    // 数字の配列を用意
    int[] a = new int[4];

    // 文字列を1文字ずつ整数に変換
    for (int i = 0; i < 4; i++) {
      a[i] = Character.getNumericValue(input.charAt(i)); // 文字を数字に変換
    }

    boolean same = true;
    boolean step = true;

    // ループの範囲修正：3つ目の要素までチェック
    for (int i = 0; i < 3; i++) {
      // 同じかどうかチェック
      if (a[i] != a[i + 1]) {
        same = false;
      }
      // ステップ順かどうかチェック
      if ((a[i] + 1) % 10 != a[i + 1] % 10) {
        step = false;
      }
    }

    // 論理OR演算子に修正
    if (same || step) {
      System.out.println("Weak");
    } else {
      System.out.println("Strong");
    }

    // Scannerを閉じる
    scanner.close();
  }
}
