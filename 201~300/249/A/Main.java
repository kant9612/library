import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();
    int e = sc.nextInt();
    int f = sc.nextInt();
    int x = sc.nextInt();
    int takahashi = 0;
    int aoki = 0;

    for (int k = 0; k < x; ++k) {
      if (k % (a + c) < a) {
        takahashi += b;
      }
      if (k % (d + f) < d) {
        aoki += e;
      }
    }

    if (takahashi < aoki) {
      System.out.println("Aoki");
    } else if (takahashi == aoki) {
      System.out.println("Draw");
    } else {
      System.out.println("Takahashi");
    }

    sc.close();
  }
}
