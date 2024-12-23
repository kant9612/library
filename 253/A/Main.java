import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力を取得
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    // 中央値判定
    if ((a <= b && b <= c) || (c <= b && b <= a)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    sc.close();
  }
}
