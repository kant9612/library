import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 入力を取得
    int n = scanner.nextInt();

    // ASCIIコードを文字に変換して出力
    char result = (char) n;
    System.out.println(result);

    scanner.close();
  }
}
