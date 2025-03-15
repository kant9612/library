
// ライブラリ.高速な素数判定法;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.close();

    System.out.print(n + ":");

    for (int i = 2; i * i <= n; i++) {
      while (n % i == 0) {
        System.out.print(" " + i);
        n /= i;
      }
    }

    if (n > 1) { // nが1より大きい場合n自体が素数になる
      System.out.print(" " + n);
    }
    System.out.println();
  }
}
