import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力を配列として受け取る
    int[] transitions = new int[10];
    for (int i = 0; i < 10; i++) {
      transitions[i] = sc.nextInt();
    }

    // 初期状態は0
    int current = 0;

    // ボタンを3回押すシミュレーション
    for (int i = 0; i < 3; i++) {
      current = transitions[current];
    }

    // 結果を出力
    System.out.println(current);

    sc.close();
  }
}
