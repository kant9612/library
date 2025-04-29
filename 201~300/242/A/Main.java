import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int x = sc.nextInt();
    double ans;

    if (x <= a) {
      ans = 1.0;
    } else if (x > a && x <= b) {
      ans = (double) c / (b - a); // キャストして小数点計算を行う
    } else {
      ans = 0.0;
    }

    // 小数点以下7桁で結果を出力
    System.out.printf("%.7f%n", ans);

    sc.close();
  }
}
