import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    // 整数の入力を受け取る
    int S = sc.nextInt(); // 整数を読み取る
    int T = sc.nextInt(); // 整数を読み取る

    int ans = 0;

    for (int a = 0; a <= S; a++) {
      for (int b = 0; b <= S; b++) {
        for (int c = 0; c <= S; c++) {
          if (a + b + c <= S && a * b * c <= T)
            ans++;
        }
      }
    }

    System.out.println(ans);
    // Scannerを閉じる
    sc.close();
  }
}