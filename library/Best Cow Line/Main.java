import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力の読み込み
    int N = sc.nextInt(); // 文字列の長さ
    String S = sc.next(); // 文字列そのもの

    // S[a], S[a+1],..., S[b] が残っている文字列
    int a = 0, b = N - 1;
    StringBuilder ans = new StringBuilder(); // 結果を保持する文字列

    while (a <= b) {
      // 左から見た場合と右から見た場合を比較
      boolean left = false;
      for (int i = 0; a + i <= b; i++) {
        if (S.charAt(a + i) < S.charAt(b - i)) {
          left = true;
          break;
        } else if (S.charAt(a + i) > S.charAt(b - i)) {
          left = false;
          break;
        }
      }

      if (left) {
        ans.append(S.charAt(a++)); // 左側の文字を選択
      } else {
        ans.append(S.charAt(b--)); // 右側の文字を選択
      }
    }

    // 結果を出力
    System.out.println(ans.toString());

    sc.close();
  }
}
