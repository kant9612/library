import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n;
    n = sc.nextInt();
    double res = Math.pow(2, n); // 累乗計算
    double ans = Math.pow(n, 2);

    if (res > ans) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    sc.close();
  }
}
