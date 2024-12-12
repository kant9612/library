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
    int x;
    int y;
    String ans;

    if (a == c) {
      x = e;
    } else if (c == e) {
      x = a;
    } else {
      x = c;
    }

    if (b == d) {
      y = f;
    } else if (d == f) {
      y = b;
    } else {
      y = d;
    }

    ans = x + " " + y;
    System.out.println(ans);

    sc.close();
  }
}
