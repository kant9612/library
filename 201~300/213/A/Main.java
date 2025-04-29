import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner scanner = new Scanner(System.in);

    // 1行で空白区切りの2つの数字を入力
    String input = scanner.nextLine(); // 1行の入力を取得

    // 空白で分割して配列に格納
    String[] numbers = input.split(" ");

    // 分割された文字列を整数に変換
    int A = Integer.parseInt(numbers[0]);
    int B = Integer.parseInt(numbers[1]);

    int C = 0;

    // xor 二進表記 排他的論理和 の考え方
    C = A ^ B;

    System.out.println(C);

    // Scannerを閉じる
    scanner.close();
  }
}