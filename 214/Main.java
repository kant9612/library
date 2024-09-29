import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner scanner = new Scanner(System.in);

    // 整数の入力を受け取る
    int N = scanner.nextInt(); // 整数を読み取る

    if (N >= 1 && N <= 125) {
      System.out.println(4);
    } else if (N >= 126 && N <= 211) {
      System.out.println(6);
    } else {
      System.out.println(8);
    }
    // Scannerを閉じる
    scanner.close();
  }
}