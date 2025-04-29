import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力を受け取る
    int N = sc.nextInt();

    // 各桁の値を取得
    int a = N / 100; // 100の位
    int b = (N / 10) % 10; // 10の位
    int c = N % 10; // 1の位

    // b, c, a の順に並べた数と c, a, b の順に並べた数を作成
    int num1 = b * 100 + c * 10 + a;
    int num2 = c * 100 + a * 10 + b;

    // 結果を出力
    System.out.println(num1 + " " + num2);

    sc.close();
  }
}
