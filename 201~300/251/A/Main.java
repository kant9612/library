import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 入力の取得
    String S = scanner.nextLine();
    int size = S.length();

    if (size == 1) {
      S = S + S + S + S + S + S;
    } else if (size == 2) {
      S = S + S + S;
    } else {
      S = S + S;
    }
    // 出力
    System.out.println(S);
  }
}
