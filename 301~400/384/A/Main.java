import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力の受け取り
    int N = sc.nextInt();
    char c1 = sc.next().charAt(0);
    char c2 = sc.next().charAt(0);
    String S = sc.next();

    // 結果を構築するStringBuilder
    StringBuilder result = new StringBuilder();

    // Sの各文字をループで確認
    for (int i = 0; i < N; i++) {
      if (S.charAt(i) == c1) {
        result.append(c1); // c1の場合はそのまま追加
      } else {
        result.append(c2); // それ以外はc2に置き換え
      }
    }

    // 結果を出力
    System.out.println(result.toString());

    sc.close();
  }
}
